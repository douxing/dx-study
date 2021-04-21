package lc;

public class RemoveDup {
    public int removeDuplicates(int[] nums) {
	if (nums.length < 2) {
	    return nums.length;
	}

	int slow = 0;
	int fast = 1;
	while (fast < nums.length) {
	    if (nums[slow] != nums[fast]) {
		slow += 1;
		nums[slow] = nums[fast];
	    }
	    fast += 1;
	}
	return slow + 1;
    }    
}
