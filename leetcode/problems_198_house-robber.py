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
        
        return self.rob1(nums)
        
class Test(unittest.TestCase):
    def setUp(self):
        self.inst = Solution()

    def test_sample_0(self):
        self.assertEqual(self.inst.rob([1]), 1)

    def test_sample_1(self):
        self.assertEqual(self.inst.rob([1, 3, 1]), 3)

    def test_sample_2(self):
        self.assertEqual(self.inst.rob([1, 3, 3, 1]), 4)

    def test_sample_3(self):
        self.assertEqual(self.inst.rob([183,219,57,193,94,233,202,154,65,240,97,234,100,249,186,66,90,238,168,128,177,235,50,81,185,165,217,207,88,80,112,78,135,62,228,247,211]), 3365)

if __name__ == '__main__':
    unittest.main()
