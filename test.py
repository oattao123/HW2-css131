from collections import deque

class BinTree:
    def __init__(self, val=None, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
    
    def __iter__(self):
        return TreeIterator(self)

class TreeIterator:
    def __init__(self, root):
        self.stack = deque()
        if root.val is not None:
            self.stack.append(root)
    
    def __iter__(self):
        return self
    
    def __next__(self):
        if not self.stack:
            raise StopIteration
        node = self.stack.pop()
        if node.right is not None:
            self.stack.append(node.right)
        if node.left is not None:
            self.stack.append(node.left)
        return node.val

if __name__ == '__main__':
    tree = BinTree(1, BinTree(2), BinTree(3))
    for i in tree:
        print(i)
