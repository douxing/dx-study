import unittest

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
        self.isRobbed = False
        self.maxInclude = 0 # may or may not include
        self.maxExclude = 0

class Solution(object):
    # self.robTree(root)
    def robTree(self, root):
        if not root:
            return

        if not hasattr(root, 'isRobbed'):
            return

        maxInclude = root.val
        maxExclude = 0
        for item in [root.left, root.right]:
            if item:
                self.robTree(item)
                maxExclude += item.maxInclude
                maxInclude += item.maxExclude

        root.maxInclude = max(maxExclude, maxInclude)
        root.maxExclude = maxExclude
        root.isRobbed = True                

    # max(self.robExclude(root), self.robInclude(root))
    def robExclude(self, root):
        if not root:
            return 0

        m = self.rob(root.left) + self.rob(root.right)
        print(m)
        return m

    def robInclude(self, root):
        if not root:
            return 0

        return self.robExclude(root.left) + root.val + self.robExclude(root.right)

    # self.robDFS(root)[1]
    def robDFS(self, node):
        if node is None:
            return (0, 0) # (exclude node, include node)

        l = self.robDFS(node.left)
        r = self.robDFS(node.right)
        return (l[1] + r[1], # exclude node
                max(l[1] + r[1], l[0] + r[0] + node.val))

    def rob(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """

        if root is None:
            return 0

        self.robTree(root)
        return root.maxInclude
        
class Test(unittest.TestCase):
    def setUp(self):
        self.inst = Solution()

    def constructTree(self, tokens):
        root = TreeNode(int(tokens[0]))
        queue = []
        current = root
        lr = 'l'
        for item in tokens[1:]:
            if item == 'null':
                if lr == 'l':
                    lr = 'r'
                else:
                    current = queue.pop(0)
                    lr = 'l'
            else:
                treeitem = TreeNode(int(item))
                queue.append(treeitem)
                if lr == 'l':
                    current.left = treeitem
                    lr = 'r'
                else:
                    current.right = treeitem
                    current = queue.pop(0)
                    lr = 'l'

        return root

    def test_sample_0(self):
        self.assertEqual(self.inst.rob(None), 0)

    def test_sample_1(self):
        self.assertEqual(self.inst.rob(TreeNode(10)), 10)

    def test_sample_2(self):
        root = TreeNode(3)
        root.left = TreeNode(2)
        root.left.right = TreeNode(3)
        root.right = TreeNode(3)
        root.right.right = TreeNode(1)

        self.assertEqual(self.inst.rob(root), 7)

    def test_sample_3(self):
        root = TreeNode(3)
        root.left = TreeNode(4)
        root.left.left = TreeNode(1)
        root.left.right = TreeNode(3)
        root.right = TreeNode(5)
        root.right.right = TreeNode(1)

        self.assertEqual(self.inst.rob(root), 9)

    def test_sample_4(self):
        root = self.constructTree("3,2,3,null,3,null,1".split(','))
        self.assertEqual(self.inst.rob(root), 7)

    def test_sample_124(self):
        with open("./problems_337_house-robber-iii_data_0.txt") as f:
            line = f.readlines()[0].strip()[1:-1]

        tokens = line.split(',')

        root = self.constructTree(tokens)
            
        self.assertEqual(self.inst.rob(root), 27106502)

if __name__ == '__main__':
    unittest.main()
