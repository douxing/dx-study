class Solution {
    public int calculate(String s) {
	// only two is enough
	int nums[] = new int[2];
	char sgns[] = new char[2];
	int idx = -1;
	int num = 0;

	for (int i = 0; i < s.length(); i += 1) {
	    char ch = s.charAt(i);
	    if (ch == ' ') {
		continue;
	    } else if (ch == '+' || ch == '-') {
		if (idx == -1) { // first item
		    nums[0] = num;
		    sgns[0] = ch;
		    idx = 0;
		    num = 0;
		    continue;
		}

		if (idx == 1) {
		    if (sgns[1] == '*') {
			num = nums[1] * num;
		    } else { // assert(sgns[idx] == '/')
			num = nums[1] / num;
		    }
		}

		// assert(idx = 0)

		if (sgns[0] == '+') {
		    num = nums[0] + num;
		} else { // assert(sngs[0] == '-');
		    num = nums[0] - num;
		}

		sgns[0] = ch;
		nums[0] = num;
		idx = 0;
		num = 0;
	    } else if (ch == '*' || ch == '/') {
		if (idx == -1) { // first item
		    nums[0] = 0;
		    sgns[0] = '+';
		    nums[1] = num;
		    sgns[1] = ch;
		    idx = 1;
		    num = 0;
		} else 	if (idx == 0) {
		    nums[1] = num;
		    sgns[1] = ch;
		    idx = 1;
		    num = 0;
		} else {
		    // assert(idx == 1);
		    if (sgns[1] == '*') {
			nums[1] = nums[1] * num;
		    } else { // assert(sgns[idx] == '/')
			nums[1] = nums[1] / num;
		    }
		    sgns[1] = ch;
		    num = 0;
		}
	    } else {
		num = num * 10 + ch - '0';
	    }
	}

	if (idx == 1) {
	    if (sgns[1] == '*') {
		num = nums[1] * num;
	    } else { // assert(sgns[idx] == '/')
		num = nums[1] / num;
	    }
	}
	if (idx >= 0) {
	    if (sgns[0] == '+') {
		num = nums[0] + num;
	    } else {
		num = nums[0] - num;
	    }	    
	}

	return num;
    }
}
