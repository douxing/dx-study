class Solution {
    class Tuple {
        int diff;
        int len;
    }
    public int wiggleMaxLength(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        List<Tuple> dp = new ArrayList(len);
        int max = 1;
        for (int i = 0; i < len; i += 1) { // index of nums
            Tuple ti = new Tuple();
            ti.len = 1;
            for (int j = 0; j < i; j += 1) { // index of dp
                Tuple tj = dp.get(j);
                int diff = nums[i] - nums[j];
                if (diff == 0) {
                    if (ti.len < tj.len) {
                        ti.len = tj.len;
                        ti.diff = tj.diff;
                    }
                } else if (tj.diff >= 0 && diff < 0 || tj.diff <= 0 && diff > 0) {
                    if (tj.len + 1 > ti.len) {
                        ti.len = tj.len + 1;
                        ti.diff = diff;
                    }
                }                
            }
            dp.add(ti);
            max = Math.max(max, ti.len);
        }
        return max;
    }
}
