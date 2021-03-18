class Solution {
    public int reverse(int x) {
	int y = 0;
	while (x >= 10 || x <= -10) {
	    y = y * 10 + x % 10;
	    x /= 10;
	}
	if (x != 0 && ((y * 10) / 10 != y)) {
	    return 0;
	}
	return y * 10 + x % 10;
    }
}
