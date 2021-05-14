class Solution {
    void add(LinkedList<List<Integer>> l, int i, int j) {
        List<Integer> ll = new ArrayList();
        ll.add(i);
        ll.add(j);
        l.addFirst(ll);
    }

    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        int rlen = obstacleGrid.length;
        int clen = obstacleGrid[0].length;
        boolean[][] dp = new boolean[rlen][];

        dp[0] = new boolean[clen];
        dp[0][0] = obstacleGrid[0][0] == 0;
        for (int i = 1; i < clen; i += 1) {
            dp[0][i] = obstacleGrid[0][i] == 0 && dp[0][i - 1];
        }

        for (int i = 1; i < rlen; i += 1) {
            dp[i] = new boolean[clen];
            dp[i][0] = obstacleGrid[i][0] == 0 && dp[i - 1][0];
            for (int j = 1; j < clen; j += 1) {
                dp[i][j] = obstacleGrid[i][j] == 0 && (dp[i - 1][j] || dp[i][j - 1]);
            }
        }

        LinkedList<List<Integer>> l = new LinkedList();

        int i = rlen - 1;
        int j = clen - 1;
        if (!dp[i][j]) {
            return l;
        }

        // System.out.println("" + i + " " + j);
        while (i > 0 && j > 0) {
            add(l, i, j);
            if (dp[i - 1][j]) {
                i -= 1;
            } else {
                j -= 1;
            }
        }
        if (i > 0) {
            while (i >= 0) {
                add(l, i, 0);
                i -= 1;
            }
        } else {
            while (j >= 0) {
                add(l, 0, j);
                j -= 1;
            }
        }

        return l;
    }
}
