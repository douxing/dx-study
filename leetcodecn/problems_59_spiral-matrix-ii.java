class Solution {
    enum Direction {
	L2R, T2D, R2L, D2T,
    }

    public int[][] generateMatrix(int n) {
	int[][] matrix = new int[n][n];

	int top = 0, down = n, left = 0, right = n;
	int cnt = 0;
	Direction d = Direction.L2R;
	int t = 0;
	while (cnt < n * n) {
	    if (d == Direction.L2R) {
		t = left;
		while (t < right) {
		    matrix[top][t] = ++cnt;
		    t += 1;
		}
		top += 1;
		d = Direction.T2D;
	    } else if (d == Direction.T2D) {
		t = top;
		while (t < down) {
		    matrix[t][right - 1] = ++cnt;
		    t += 1;
		}
		right -= 1;
		d = Direction.R2L;
	    } else if (d == Direction.R2L) {
		t = right - 1;
		while (t >= left) {
		    matrix[down - 1][t] = ++cnt;
		    t -= 1;
		}
		down -= 1;
		d = Direction.D2T;
	    } else {
		// assert(d == Direction.D2T)
		t = down - 1;
		while (t >= top) {
		    matrix[t][left] = ++cnt;
		    t -= 1;
		}
		left += 1;
		d = Direction.L2R;
	    }
	}

	return matrix;
    }
}
