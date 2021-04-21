package leetcode;

import java.util.*;

class Solution {
    class Pair {
	Pair(int low, int high) {
	    this.low = low;
	    this.high = high;
	}

	public int low;
	public int high;
    }

    public boolean find132pattern(int[] nums) {
	if (nums.length < 3) {
	    return false;
	}

	Deque<Pair> deq = new LinkedList();
	int lowest = nums[0];
	int lowestHigh = nums[0];
	for (int i = 1; i < nums.length; i += 1) {
	    int n = nums[i];
	    if (n == lowest || n == lowestHigh) {
		continue;
	    } else if (n < lowest) {
		if (lowestHigh > lowest + 1) {
		    deq.push(new Pair(lowest, lowestHigh));
		}
		lowest = lowestHigh = n;
		continue;
	    } else if (n < lowestHigh) {
		return true;
	    }

	    Pair p = deq.peek();
	    while (p != null) {
		if (n <= p.low) {
		    break;
		} else if (n < p.high) {
		    return true;
		} else { // n >= p.high
		    deq.pop();
		}
		p = deq.peek();
	    }
	    lowestHigh = n;
	}

	return false;
    }
}
