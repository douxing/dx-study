class Solution {
    // if it is a valid tree, assertion:
    // 1. when the parse ends: count(#) = count(num) + 1
    // 2. there should be no more inputs when assertion#1 above is meet
    // to be prove: there should be one and only one tree to satisfy
    public boolean isValidSerialization(String preorder) {
	int degree = 1;
	boolean isNum = false;
	for (int i = 0; i < preorder.length(); i += 1) {
	    if (preorder.charAt(i) == '#') {
		degree -= 1;
	    } else if (preorder.charAt(i) == ',') {
		if (degree == 0) { // assertion#2
		    return false;
		}
		isNum = false;
	    } else /* a number */ if (!isNum) {
		isNum = true;
		degree += 1;
	    }
	}

	return degree == 0; // assertion#1
    }
}
