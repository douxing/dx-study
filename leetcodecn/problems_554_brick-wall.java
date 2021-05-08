class Solution {
    void pdp(int[] dp) {
        for(int i = 0; i < dp.length; i++) {
            if (i ==0) {
            System.out.print("[" + dp[i]);
            } else if (i == dp.length - 1) {
            System.out.println(", " + dp[i] +"]");
                
            } else {
            System.out.print(", " + dp[i]);

            }
        }
    }

    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> m = new HashMap();
        for (int i = 0; i < wall.size(); i += 1) {
            List<Integer> row = wall.get(i);
            int index = 0;
            for (int j = 0; j < row.size() - 1; j += 1) {
                index += row.get(j);
                Integer cnt = m.get(index);
                if (cnt == null) {
                    m.put(index, 1);
                } else {
                    m.put(index, cnt + 1);
                }
            }
        }

        int max = 0;
        for (int v : m.values()) {
            max = Math.max(max, v);
        }
        
        return wall.size() - max;
    }
}
