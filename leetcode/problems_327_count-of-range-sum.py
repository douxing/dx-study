import unittest

class Solution(object):
    def countRangeSum(self, nums, lower, upper):
        """
        :type nums: List[int]
        :type lower: int
        :type upper: int
        :rtype: int
        """
        
        sums = 0 # left N sums
        ssums = [sums] # sorted sums
        counter = 0

        import bisect
        for num in nums:
            sums += num
            # sum - ssums[i] >= lower => ssums[i] <= sums - lower
            # sum - ssums[j] <= upper => ssums[j] >= sums - upper
            i = bisect.bisect_right(ssums, sums - lower)
            j = bisect.bisect_left(ssums, sums - upper)

            # print(ssums, i, j, sums)
        
            if j < i:
                counter += i - j
            
            bisect.insort_left(ssums, sums)

        return counter

class Test(unittest.TestCase):
    def setUp(self):
        self.inst = Solution()

    def test_description(self):
        self.assertEqual(self.inst.countRangeSum([-2, 5, -1], -2, 2), 3)

if __name__ == '__main__':
    unittest.main()
