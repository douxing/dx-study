package lc;

public class VolumeOfHistogram {
    public int trap(int[] height) {
	if (height.length < 3) {
	    return 0;
	}
	int cap = 0;
	int left = 0;
	int right = height.length - 1;
	int min = height[right];
	boolean moveLeft = false;
	if (height[left] <= height[right]) {
	    min = height[left];
	    moveLeft = true;
	}
	while (left < right - 1) {
	    if (moveLeft) {
		left += 1;
		if (height[left] <= min) {
		    cap += min - height[left];
		} else if (height[left] > height[right]) {
		    min = height[right];
		    moveLeft = false;
		} else {
		    min = height[left];
		}
	    } else {
		right -= 1;
		if (height[right] <= min) {
		    cap += min - height[right];
		} else if (height[left] <= height[right]) {
		    min = height[left];
		    moveLeft = true;
		} else {
		    min = height[right];
		}
	    }
	}
	return cap;
    }
}
