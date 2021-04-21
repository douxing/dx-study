package lc;

public class SearchSorted {

    int bs1(int nums[], int left, int right, int target) {
	while (left <= right) {
	    int mid = (left + right) / 2;
	    if (nums[mid] < target) {
		left = mid + 1;
	    } else if (target < nums[mid]) {
		right = mid - 1;
	    } else {
		return mid;
	    }
	}
	return -1;
    }

    int bs(int nums[], int left, int right, int target) {
	System.out.println("target: " + target);
	while (left <= right) {
	    int mid = (left + right) / 2;
	    // System.out.println("left: " + left);
	    // System.out.println("mid: " + mid);
	    // System.out.println("right: " + right);

	    if (nums[left] <= nums[mid]) {
		if (nums[left] <= target && target <= nums[mid]) {
		    return bs1(nums, left, mid, target);
		} else {
		    left = mid + 1;
		}
	    } else { // assert num[mid] < nums[right]
		if (nums[mid] <= target && target <= nums[right]) {
		    return bs1(nums, mid, right, target);
		} else {
		    right = mid - 1;
		}
	    }

	    // System.out.println("left: " + left);
	    // System.out.println("mid: " + mid);
	    // System.out.println("right: " + right);
	    // System.out.println("---------------------");
	}

	return -1;
    }

    public int search(int[] nums, int target) {
	return bs(nums, 0, nums.length - 1, target);
    }


}

    // class Solution {

    // 	public boolean search(int[] nums, int target) {
    // 	    for (int i = 0; i < nums.length; i += 1) {
    // 		if (target == nums[i]) {
    // 		    return true;
    // 		}
    // 	    }

    // 	    return false;
    // 	}
    // }
