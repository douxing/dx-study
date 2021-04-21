class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        int c = 0;
        int i = nums.length - 1;
        while (true) {
            while (nums[c] != val && c < i) {
                c += 1;
            }
            while (nums[i] == val && i > c) {
                i -= 1;
            }
            if (c < i) {
                nums[c++] = nums[i--];
            } else {
                if (c == i && nums[c] != val) {
                    c += 1;
                }
                break;
            }
        }
        return c;
    }
    /*
    public int removeElement(int[] nums, int val) {
        int c = 0;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != val) {
                nums[c] = nums[i];
                c += 1;
            }
            i += 1;
        }
        return c;
    }
    */
}
