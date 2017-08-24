import unittest

class Solution(object):
    def minSubArrayLen(self, s, nums):
        """
        :type s: int
        :type nums: List[int]
        :rtype: int
        """

        i, j, total, minlen = 0, 0, 0, len(nums) + 1
        while j < len(nums):
            total += nums[j]
            j += 1

            while total >= s: # && i < j
                total -= nums[i]
                minlen = min(minlen, j - i)
                i += 1

        if minlen == len(nums) + 1:
            minlen = 0

        return minlen

class Test(unittest.TestCase):
    def setUp(self):
        self.inst = Solution()

    def test_description(self):
        self.assertEqual(self.inst.minSubArrayLen(7, [2,3,1,2,4,3]), 2)
        
if __name__ == '__main__':
    unittest.main()
