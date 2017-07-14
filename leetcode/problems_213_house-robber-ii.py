import unittest

class Solution(object):
    def rob1(self, nums):
        if not nums:
            return 0
        elif len(nums) == 1:
            return nums[0]

        # mid >= 1
        mid = len(nums) // 2
        return max(self.rob1(nums[:mid-1]) + nums[mid] + self.rob1(nums[mid+2:]),
                self.rob1(nums[:mid]) + self.rob1(nums[mid+1:]))

    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """

        if not nums:
            return 0
        elif len(nums) == 1:
            return nums[0]

        return max(self.rob1(nums[1:]), self.rob1(nums[:-1]))
        
class Test(unittest.TestCase):
    def setUp(self):
        self.inst = Solution()

    def test_sample_0(self):
        self.assertEqual(self.inst.rob([1]), 1)

    def test_sample_1(self):
        self.assertEqual(self.inst.rob([1, 3, 1]), 3)

    def test_sample_2(self):
        self.assertEqual(self.inst.rob([1, 3, 3, 1]), 4)

if __name__ == '__main__':
    unittest.main()
