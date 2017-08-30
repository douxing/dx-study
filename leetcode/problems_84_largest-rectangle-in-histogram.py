import unittest

# http://www.geeksforgeeks.org/largest-rectangle-under-histogram/
# http://www.geeksforgeeks.org/largest-rectangular-area-in-a-histogram-set-1/
# http://www.geeksforgeeks.org/segment-tree-set-1-range-minimum-query/
# http://www.geeksforgeeks.org/segment-tree-set-1-sum-of-given-range/

# 这道题使用一个stack来维护高度的“索引”，而不是高度本身
# 这个stack有这样的不变性：
# 每次插入一个索引(new)，都需要和之前的索引(old)比较“对应位置的高度”
# 如果new对应的高度(heights[new])大于等于先前的索引对应的高度(>=heights[old])，那就把这个索引加入stack
# 如果新的索引对应的高度(heights[new])小于先前的索引对应的高度(<heights[old])
# 那需要将先前的索引弹出stack，并获取其高度(h = heights[old])
# 并计算先前索引高度所占有的宽度(w)
# 首先确定宽度的左边值，这就是先前索引的前一个索引的值(older)(不包括本身)
# 这是因为我们在插入索引时，会把之前所有高度大于该索引的索引全部出栈
# 所以剩下的那些索引对应的高度都是小于这个高度值的
# 如果先前的索引之前没有更多的索引，那说明现在的索引是前面所有索引中对应高度最小的一个，所有左边的都应该算上
# 然后确定宽度的右边值，这就是被插入的索引值
# 这里有两种情况：
# 1, old = new - 1, 也就是新插入的情况，这是很好理解的
# 2, old < new - 1, 这是连续弹出stack的情况，因为右侧索引对应的高度都一定比当前old大
# 所以右边距就是new(不包括本身)

class Solution(object):
    def largestRectangleArea(self, heights):
        """
        :type heights: List[int]
        :rtype: int
        """
        
        maxval = 0
        heights.append(0)
        indexes = []

        for index in range(len(heights)):
            # using >= becase 0 is the last in heights
            while indexes and heights[indexes[-1]] > heights[index]:
                h = heights[indexes[-1]]
                indexes.pop()
                while indexes and h == heights[indexes[-1]]:
                    indexes.pop()
                w = index if not indexes else index - indexes[-1] - 1
                maxval = max(maxval, h*w)
            indexes.append(index)

        return maxval
        
        
class Test(unittest.TestCase):
    def setUp(self):
        self.inst = Solution()

    def test_description(self):
        self.assertEqual(10, self.inst.largestRectangleArea([2,1,5,6,2,3]))

if __name__ == '__main__':
    unittest.main()
