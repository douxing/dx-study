import unittest

class Solution(object):
    def trapRainWater(self, heightMap):
        """
        :type heightMap: List[List[int]]
        :rtype: int
        """

        if len(heightMap) < 3 or len(heightMap[0]) < 3:
            return 0

        height = len(heightMap)
        width = len(heightMap[0])

        import heapq

        heap = []
        visited = [[False] * width for _ in range(height)]

        for x in range(0, height):
            for y in range(0, width):
                if x == 0 or x == height - 1 or y == 0 or y == width - 1:
                    heapq.heappush(heap, (heightMap[x][y], x, y))
                    visited[x][y] = True

        result = 0
        while heap:
            h, x, y = heapq.heappop(heap)
            for x, y in ((x-1, y), (x+1, y), (x, y-1), (x, y+1)):
                if 0 <= x < height and 0 <= y < width and not visited[x][y]:
                    # valid item
                    result += max(0, h-heightMap[x][y])
                    visited[x][y] = True
                    heapq.heappush(heap, (max(heightMap[x][y], h), x, y))

        return result
        
class Test(unittest.TestCase):
    def setUp(self):
        self.inst = Solution()

    def test_sample(self):
        self.assertEqual(4, self.inst.trapRainWater([
            [1,4,3,1,3,2],
            [3,2,1,3,2,4],
            [2,3,3,2,3,1],
        ]))

if __name__ == '__main__':
    unittest.main()
