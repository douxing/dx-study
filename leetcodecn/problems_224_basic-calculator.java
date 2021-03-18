class Solution {
    public int calculate(String s) {
	Deque<Integer> nums = new LinkedList();
	Deque<Integer> signs = new LinkedList();
	int num = 0;

	for (int i = 0; i < s.length(); i += 1) {
	    char ch = s.charAt(i);
	    if (ch == ' ') {
		// do nothing
	    } else if (ch == '+' || ch == '-') {
		if (signs.peek() != null && signs.peek().intValue() != 0) {
		    int a = nums.pop().intValue();
		    nums.push(a + signs.pop().intValue() * num);
		} else {
		    nums.push(num);
		}
		signs.push(ch == '+' ? 1 : -1);
		num = 0;
	    } else if (ch == '(') {
		// only sign before (, so no need to reset num = 0
		// assert(num == 0)
		signs.push(0);
	    } else if (ch == ')') {
		Integer sign = signs.pop();
		if (sign != null && sign.intValue() != 0) {
		    // handle "(a + b)"
		    num = nums.pop().intValue() + sign * num;
		    signs.pop();
		} // else: single number in braces: "(a)" <- disgusting
	    } else {
		// numbers
		num = num * 10 + ch - '0';
	    }
	}

	if (signs.peek() != null) {
	    num = nums.pop().intValue() + signs.pop().intValue() * num;	    
	}

	return num;
    }
}
