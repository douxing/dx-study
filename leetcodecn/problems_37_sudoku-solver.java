class Solution {
    boolean avail(char[][] board, int x, int y, char ch) {
	int xx = (x / 3) * 3;
	int yy = (y / 3) * 3;
	for (int i = 0; i < 9; i += 1) {
	    if (board[x][i] == ch // row x
		|| board[i][y] == ch // column y
		|| board[xx + i/3][yy + i%3] == ch) // square contains (x,y)
		{
		    return false;
		}
	}

	return true;
    }

    boolean bt(char[][] board, int index) {
	if (index == 81) {
	    return true;
	}

	int x = index / 9;
	int y = index % 9;

	if ('.' != board[x][y]) {
	    return bt(board, index + 1);
	}

	// assert(board[x][y] == '.');
	for (int i = 0; i < 9; i += 1) {
	    char ch = (char)('1' + i);
	    if (avail(board, x, y, ch)) { // set, try, reset
		board[x][y] = ch;
		if (bt(board, index + 1)) {
		    return true;
		}
	    }
	}
	board[x][y] = '.'; // keep assertion
	return false;
    }

    public void solveSudoku(char[][] board) {
	bt(board, 0);
    }
}
