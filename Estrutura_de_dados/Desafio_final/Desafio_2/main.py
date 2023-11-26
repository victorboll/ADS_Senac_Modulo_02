# Morse Code Using a Binary Tree - www.101computing.net/morse-code-using-a-binary-tree/

from tree import drawTree  # This library will only be used to draw the binary tree on the screen


# A class to implement a Node / Tree
class Node:
    def __init__(self, value, left=None, right=None):
        self.value = value
        self.left = left
        self.right = right

    def __str__(self):
        return self.value


# Convert Character (Find the character using a pre-order traversal of the Binary Tree
def getMorseCode(node, character, code):
    if node == None:
        return False
    elif node.value == character:
        return True
    else:
        if getMorseCode(node.left, character, code) == True:
            code.insert(0, ".")
            return True
        elif getMorseCode(node.right, character, code) == True:
            code.insert(0, "-")
            return True


def getMessage():
    return True
    #Your code here!!

# Let's initialise our binary tree:
tree = Node(" ")  # The root node of our binary tree

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
"""
message = input("Enter a message to convert into Morse Code: (e.g. SOS)").upper()
morseCode = ""

# Convert the message, one character at a time!
for character in message:
    dotsdashes = []
    getMorseCode(tree, character, dotsdashes)
    code = "".join(dotsdashes)
    morseCode = morseCode + code + " "

print(morseCode)
"""

def getCaractere(raiz, codigo):
    if codigo == " ":
        return " "
    elif codigo == '':
        return raiz.value
    elif codigo[0] == '.':
        return getCaractere(raiz.left, codigo[1:])
    elif codigo[0] == '-':
        return getCaractere(raiz.right, codigo[1:])


mensagem_em_morse = input("Digite uma mensagem em código Morse para ser traduzida para texto\n"
                          "(ex.: ... --- ...  ... --- ...= SOS SOS): \n")
mensagem_em_morse = mensagem_em_morse.replace("  ", " _ ")
mensagem_em_morse = mensagem_em_morse.split()
for i in range(len(mensagem_em_morse)):
    if mensagem_em_morse[i] == '_':
        mensagem_em_morse[i] = ' '
mensagem_em_texto = ""

for codigo in mensagem_em_morse:
    getCaractere(tree, codigo)
    mensagem_em_texto = mensagem_em_texto + getCaractere(tree, codigo)

print(mensagem_em_texto)






