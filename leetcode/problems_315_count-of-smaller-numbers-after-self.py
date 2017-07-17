import unittest

class Solution(object):
    def countSmaller(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """

        sorted = [] # index
        result = []
        
        from bisect import bisect_left
        for num in reversed(nums):
            index = bisect_left(sorted, num) # index == count
            result.insert(0, index)
            sorted.insert(index, num)
        
        return result

class Test(unittest.TestCase):
    def setUp(self):
        self.inst = Solution()

    def test_sample_0(self):
        self.assertEqual(self.inst.countSmaller([5, 2, 6, 1]),
                         [2, 1, 1, 0])

if __name__ == '__main__':
    unittest.main()
