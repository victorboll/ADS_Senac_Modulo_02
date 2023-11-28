class Binarytree:
    def __init__(self, value=None, left=None, right=None):
        self.value = value
        self.left = left
        self.right = right

    def insert(self, root, item):
        if root is None:
            return
        elif root.value > item.value:
            if root.left is None:
                root.left = item
            else:
                self.insert(root.left, item)
        elif root.value < item.value:
            if root.right is None:
                root.right = item
            else:
                self.insert(root.right, item)

    def biggest(self, root):
        if root.right is None:
            return root.value
        else:
            return self.biggest(root.right)

    def smallest(self, root):
        if root.left is None:
            return root.value
        else:
            return self.smallest(root.left)

    def is_simetric(self, root_left, root_right):
        if root_left is not None and root_right is not None:
            return self.is_simetric(root_left.left, root_right.left) and 
            self.is_simetric(root_left.right, root_right.right)
        elif root_left is None and root_right is None:
            return True
        else:
            return False

    def get_height(self, root):
        if root.left is not None or root.right is not None:
            if root.left is not None and root.right is not None:
                left_height = 1 + self.get_height(root.left)
                right_height = 1 + self.get_height(root.right)
            elif root.left is None:
                right_height = 1 + self.get_height(root.right)
                left_height = 0
            else:
                left_height = 1 + self.get_height(root.left)
                right_height = 0
            if left_height > right_height:
                return left_height
            else:
                return right_height
        else:
            return 0

    def is_balanced(self, root):
        if root.left is not None and root.right is not None:
            if abs(self.get_height(root.left) - self.get_height(root.right)) <= 1:
                return self.is_balanced(root.left) and self.is_balanced(root.right)
            else:
                return False
        elif root.left is None and root.right is None:
            return True
        elif root.left is None:
            if self.get_height(root.right) - 0 <= 1:
                return True
            else:
                return False
        elif root.right is None:
            if self.get_height(root.left) - 0 <= 1:
                return True
            else:
                return False

    def is_identical(self, root, tree2) -> bool:
        if root is None and tree2 is None:
            return True
        elif root is not None and tree2 is not None:
            if root.value == tree2.value:
                return self.is_identical(root.left, tree2.left) and self.is_identical(root.right, tree2.right)
            else:
                return False
        else:
            return False
            
