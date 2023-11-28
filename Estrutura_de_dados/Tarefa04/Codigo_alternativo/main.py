from tree import drawTree

tree_1 = BinaryTree(10)
tree_2 = BinaryTree(10)

for tree_key in [20, 40, 30, 60, 50, 5]:
    item_tree = BinaryTree(value=tree_key)
    tree_1.insert(tree_1, item_tree)

for tree_key in [20, 40, 30, 60, 50, 5]:
    item_tree = BinaryTree(value=tree_key)
    tree_2.insert(tree_2, item_tree)

drawTree(tree_1)

if tree_1.is_identical(tree_1, tree_2):
    print(f'são iguais')
else:
    print(f'não são iguais')

if tree_1.is_simetric(tree_1.left, tree_1.right):
    print(f"é simetrico")
else:
    print(f"não é simetrica")

if tree_1.is_balanced(tree_1):
    print(f"é balanceada")
else:
    print(f"não é balanceada")

print(tree_1.smallest(tree_1))
