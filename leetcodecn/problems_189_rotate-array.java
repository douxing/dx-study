class Solution {
    void rev(int[] nums, int begin, int end) {
        for (int i = begin; i < (begin + end) / 2; i += 1) {
            int t = nums[i];
            nums[i] = nums[begin + end - i - 1];
            nums[begin + end - i - 1] = t;
        }
    }

    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        rev(nums, 0, nums.length);
        rev(nums, 0, k);
        rev(nums, k, nums.length);

    }
}
