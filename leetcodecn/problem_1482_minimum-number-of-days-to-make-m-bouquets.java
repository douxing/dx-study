class Solution {
    boolean cando(int[] bloomDay, int day, int m, int k) {
        int count = 0;
        for (int i = 0; i < bloomDay.length; i += 1) {
            if (bloomDay[i] <= day) {
                count += 1;
                if (count == k) {
                    count = 0;
                    if (m == 1) return true;
                    m -= 1;
                }
            } else {
            count = 0;
            }
        }

        return false;
    }


    public int minDays(int[] bloomDay, int m, int k) {
        int len = bloomDay.length;
        if (len < m * k) return -1;

        int left = 1;
        int right = 999999999;

        while (left <= right) {
            int mid = (left + right) /2 ;
            if (cando(bloomDay, mid, m, k)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            //System.out.println("" + left + " " + right);
        }

        return left;
    }
}
