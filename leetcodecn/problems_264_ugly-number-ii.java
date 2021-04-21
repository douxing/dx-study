package lc;

public class UglyNumberII {
    public int nthUglyNumber(int n) {
	if (n <= 0) {
	    return 0;
	}
	int idx2 = 0;
	int idx3 = 0;
	int idx5 = 0;

	int[] uglies = new int[n];
	uglies[0] = 1;
	for (int i = 1; i < n; i += 1) {
	    int n2 = uglies[idx2] * 2;
	    int n3 = uglies[idx3] * 3;
	    int n5 = uglies[idx5] * 5;

	    int min = n2;
	    if (n3 < min) min = n3;
	    if (n5 < min) min = n5;

	    if (min == n2) idx2 += 1;
	    if (min == n3) idx3 += 1;
	    if (min == n5) idx5 += 1;
	    uglies[i] = min;
	}

	return uglies[n - 1];
    }
}
