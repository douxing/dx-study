package lc;

public class MinRo {
    static int MAX = 6000;

    int bsmin(int[] nums, int left, int right) {
	if (left > right) {
	    return MAX;
	} else if (left == right) {
	    return nums[left];
	}

	if (nums[left] < nums[right]) {
	    return nums[left];
	}

	// assert right - left >= 1 => mid + 1 <= right
	int mid = (left + right) / 2;
	return Math.min(bsmin(nums, left, mid),
			bsmin(nums, mid + 1, right));
    }

    public int findMin(int[] nums) {
	return bsmin(nums, 0, nums.length - 1);
    }
}
