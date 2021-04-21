package lc;

import java.lang.Math;
import java.util.Arrays;

public class LargestNumber {
    public String largestNumber(int[] nums) {
	String[] ss = new String[nums.length];
	for (int i = 0; i < nums.length; i += 1) {
	    ss[i] = String.valueOf(nums[i]);
	}
	Arrays.sort(ss, (one, two) -> {
		String lr = one + two;
		String rl = two + one;
		return rl.compareTo(lr);
	    });

	if (ss[0].equals("0")) {
	    return "0";
	}

	StringBuilder sb = new StringBuilder();
	for (int i = 0; i < nums.length; i += 1) {
	    sb.append(ss[i]);
	}

	return sb.toString();
    }
}
