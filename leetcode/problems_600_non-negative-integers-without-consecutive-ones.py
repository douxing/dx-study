# python3

import unittest

class Solution:
    def find(self, cache, cache_total, numstr):
        if len(numstr) == 0:
            raise 'never happen'
        elif len(numstr) < 3:
            return cache_total[len(numstr) - 1]

        # len(numstr) >= 3
        base = cache_total[len(numstr) - 2]
        if numstr[1] == '1':
            return base + cache_total[len(numstr) - 3]

        for i in range(2, len(numstr)):
            if numstr[i] == '1':
                return base + self.find(cache, cache_total, numstr[i:])

        return base + 1

    def findIntegers(self, num):
        """
        :type num: int
        :rtype: int
        """

        numstr = "{:b}".format(num)
        cache = [2, 1, 2] # leading 1 and rest are 0s
        cache_total = [2]

        for i in range(1, len(numstr)):
            if i > 2:
                cache.append(cache[i - 1] + cache[i - 2])
            cache_total.append(cache_total[i - 1] + cache[i])

        return self.find(cache, cache_total, numstr)

class Test(unittest.TestCase):
    def setUp(self):
        self.inst = Solution()

    def test_2(self):
        self.assertEquals(3, self.inst.findIntegers(2))

    def test_4(self):
        self.assertEquals(4, self.inst.findIntegers(4))

    def test_5(self):
        self.assertEquals(5, self.inst.findIntegers(5))

    def test_6(self):
        self.assertEquals(5, self.inst.findIntegers(6))

if __name__ == '__main__':
    unittest.main()
