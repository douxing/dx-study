class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int len = arr.length;
        int[] pres = new int[len + 1];

        pres[0] = 0;
        for (int i = 1; i <= len; i += 1) {
            pres[i] = pres[i - 1] ^ arr[i - 1];
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i += 1) {
            ans[i] = pres[queries[i][1] + 1] ^ pres[queries[i][0]];
        }

        return ans;
    }
}
