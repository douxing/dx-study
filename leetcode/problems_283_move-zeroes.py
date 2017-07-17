import unittest

class Solution(object):
    def moveZeroes(self, nums):
        lastNoneZero = 0
        for num in nums:
            if num is not 0:
                nums[lastNoneZero] = num
                lastNoneZero += 1

        for index in range(lastNoneZero, len(nums)):
            nums[index] = 0

    def moveZeroes1(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """

        zi = None # zero index
        nzi = 0 # non-zero index

        while True:
            zi = None
            for index in range(nzi, len(nums)):
                if nums[index] is 0:
                    zi = index
                    break

            if zi is None:
                break
        
            nzi = None
            for index in range(zi + 1, len(nums)):
                if nums[index] is not 0:
                    nzi = index
                    break

            if nzi is None:
                break

            nums[zi], nums[nzi] = nums[nzi], nums[zi]
            nzi = zi + 1

class Test(unittest.TestCase):
    def setUp(self):
        self.inst = Solution()

    def test_sample_0(self):
        inp = [0, 1, 0, 3, 12]
        self.inst.moveZeroes(inp)
        self.assertEqual(inp, [1, 3, 12, 0, 0])

if __name__ == '__main__':
    unittest.main()
