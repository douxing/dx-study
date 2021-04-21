package lc;

public class RemoveDup {
    // public int removeDuplicates(int[] nums) {
    //	if (nums.length < 2) {
    //	    return nums.length;
    //	}

    //	int slow = 0;
    //	int fast = 1;
    //	while (fast < nums.length) {
    //	    if (nums[slow] != nums[fast]) {
    //		slow += 1;
    //		nums[slow] = nums[fast];
    //	    }
    //	    fast += 1;
    //	}
    //	return slow + 1;
    // }

    public int removeDuplicates(int[] nums) {
	if (nums.length < 2) {
	    return nums.length;
	}

	int slow = 0;
	int fast = 1;
	int dup = 1;

	while (fast < nums.length) {
	    if (nums[fast] == nums[fast - 1]) {
		dup += 1;
	    } else { // nums[fast] is new
		nums[slow++] = nums[fast - 1];
		if (dup > 1) {
		    nums[slow++] = nums[fast - 1];
		}
		dup = 1;
	    }
	    fast += 1;
	}

	nums[slow++] = nums[fast - 1];
	if (dup > 1) {
	    nums[slow++] = nums[fast - 1];
	}

	return slow;
    }
}
