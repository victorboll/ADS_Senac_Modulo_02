# Morse Code Using a Binary Tree - www.101computing.net/morse-code-using-a-binary-tree/

from tree import drawTree  # This library will only be used to draw the binary tree on the screen
import unicodedata

# A class to implement a Node / Tree
class Node:
    def __init__(self, value, left=None, right=None):
        self.value = value
        self.left = left
        self.right = right


# Convert Character (Find the character using a pre-order traversal of the Binary Tree
def getMorseCode(node, character, code):
    if node is None:
        return False
    elif node.value == character:
        return True
    else:
        if getMorseCode(node.left, character, code):
            code.insert(0, ".")
            return True
        elif getMorseCode(node.right, character, code):
            code.insert(0, "-")
            return True


# Your code here!!
def getMessage(node, code, letter):
    if not code:
        letter.insert(0, node.value.lower())
        return True
    elif code[0] == "-":
        getMessage(node.right, code[1:], letter)
    elif code[0] == ".":
        getMessage(node.left, code[1:], letter)
    elif code[0] == "*":
        letter.insert(0, " ")
        return True
    else:
        return f"Not a valid code"


# Let's initialise our binary tree:
tree = Node("START")  # The root node of our binary tree

# 1st Level
tree.left = Node("E")
tree.right = Node("T")

# 2nd Level
tree.left.left = Node("I")
tree.left.right = Node("A")
tree.right.left = Node("N")
tree.right.right = Node("M")

# 3rd Level
tree.left.left.left = Node("S")
tree.left.left.right = Node("U")
tree.left.right.left = Node("R")
tree.left.right.right = Node("W")

tree.right.left.left = Node("D")
tree.right.left.right = Node("K")
tree.right.right.left = Node("G")
tree.right.right.right = Node("O")

# 4th Level
tree.left.left.left.left = Node("H")
tree.left.left.left.right = Node("V")
tree.left.left.right.left = Node("F")
tree.left.left.right.right = Node("")
tree.left.right.left.left = Node("L")
tree.left.right.left.right = Node("")
tree.left.right.right.left = Node("P")
tree.left.right.right.right = Node("J")

tree.right.left.left.left = Node("B")
tree.right.left.left.right = Node("X")
tree.right.left.right.left = Node("C")
tree.right.left.right.right = Node("Y")
tree.right.right.left.left = Node("Z")
tree.right.right.left.right = Node("Q")
tree.right.right.right.left = Node("")
tree.right.right.right.right = Node("")

drawTree(tree)

# Message Input
message = input("Enter a message to convert into Morse Code: (e.g. SOS) ").upper()
normalized_message = ''.join(unicodedata.normalize('NFD', char) for char in message)
ascii_message = normalized_message.encode('ascii', 'ignore').decode('utf-8')
morseCode = ""

# Convert the message, one character at a time!
for character in ascii_message:
    dotsdashes = []
    getMorseCode(tree, character, dotsdashes)
    code = "".join(dotsdashes)
    morseCode = morseCode + code + " "

print(morseCode)

morseCode = input("Enter a morse code: ")
codes = list(map(lambda x: '*' if x == '' else x, morseCode.strip().split(" ")))
decipher_message = ""

for code in codes:
    letter = []
    getMessage(tree, code, letter)
    word = "".join(letter)
    decipher_message += word

print(decipher_message)
