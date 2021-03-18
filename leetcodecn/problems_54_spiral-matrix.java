class Solution {
    enum Direction {
	L2R, T2D, R2L, D2T,
    }

    public List<Integer> spiralOrder(int[][] matrix) {
	int m = matrix.length;
	int n = matrix[0].length;
	// 1 <= m, n <= 10

	List<Integer> res = new LinkedList();
	int top = 0, down = m, left = 0, right = n;
	int cnt = 0, total = m * n;
	Direction d = Direction.L2R;
	int t;
	while (cnt < total) {
	    if (d == Direction.L2R) {
		t = left;
		while (t < right) {
		    res.add(new Integer(matrix[top][t]));
		    t += 1;
		}
		top += 1;
		cnt += right - left;
		d = Direction.T2D;
	    } else if (d == Direction.T2D) {
		t = top;
		while (t < down) {
		    res.add(new Integer(matrix[t][right - 1]));
		    t += 1;
		}
		right -= 1;
		cnt += down - top;
		d = Direction.R2L;
	    } else if (d == Direction.R2L) {
		t = right - 1;
		while (t >= left) {
		    res.add(new Integer(matrix[down - 1][t]));
		    t -= 1;
		}
		down -= 1;
		cnt += right - left;
		d = Direction.D2T;
	    } else {
		// assert(d == Direction.D2T)
		t = down - 1;
		while (t >= top) {
		    res.add(new Integer(matrix[t][left]));
		    t -= 1;
		}
		left += 1;
		cnt += down - top;
		d = Direction.L2R;
	    }
	}

	return res;
    }
}
