package lc;

import java.lang.Math;

public class MergeSorted {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
	int idx1 = m - 1;
	int idx2 = n - 1;
	int idxEmpty = m + n - 1;
	while (idx1 >= 0 && idx2 >= 0) {
	    if (nums1[idx1] < nums2[idx2]) {
		nums1[idxEmpty--] = nums2[idx2--];
	    } else {
		nums1[idxEmpty--] = nums1[idx1--];
	    }
	}

	while (idx2 >= 0) {
	    nums1[idxEmpty--] = nums2[idx2--];	    
	}
    }
}
