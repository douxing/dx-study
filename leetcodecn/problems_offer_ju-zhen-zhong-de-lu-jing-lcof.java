class Solution {
    boolean dfs(char[][] board, int x, int y, String word, int index) {
	if (index == word.length()) {
	    return true;
	}

	if (x < 0 || x >= board.length || y < 0 || y >= board[x].length) {
	    return false;
	}

	char ch = board[x][y];
	if (word.charAt(index) != ch) {
	    return false;
	}

	board[x][y] = '\0';
	if (dfs(board, x, y - 1, word, index + 1)
	    || dfs(board, x + 1, y, word, index + 1)
	    || dfs(board, x, y + 1, word, index + 1)
	    || dfs(board, x - 1, y, word, index + 1)) {
	    return true;
	}
	board[x][y] = ch;
	return false;
    }

    public boolean exist(char[][] board, String word) {
	for (int i = 0; i < board.length; i += 1) {
	    for (int j = 0; j < board[i].length; j += 1) {
		if (dfs(board, i, j, word, 0)) {
		    return true;
		}
	    }
	}
	return false;
    }
}
