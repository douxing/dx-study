
class Solution {
    public int massage(int[] nums) {
        if (nums.length == 0) return 0;
        else if (nums.length == 1) return nums[0];

        int prepre = 0;
        int pre = 0;
        int cur = nums[0];
        for (int i = 1; i < nums.length; i += 1) {
            prepre = pre;
            pre = cur;
            cur = Math.max(nums[i] + prepre, pre);
        }

        return cur;
    }
}
