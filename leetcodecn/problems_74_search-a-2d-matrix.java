package leetcode;

public class Solution {
    // you need treat n as an unsigned value
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length - 1;
        int row = -1;
        int col = -1;
        while (left <= right) {
            row = (left + right) / 2;
            col = matrix[row].length - 1;
            if (matrix[row][col] < target) {
                left = row + 1;
            } else if (matrix[row][0] > target) {
                right = row - 1;
            } else { // matrix[row][0] <= target <= matrix[row][col]
                left = 0;
                right = col;
                while (left <= right) {
                    col = (left + right) / 2;
                    if (matrix[row][col] < target) {
                        left = col + 1;
                    } else if (matrix[row][col] > target) {
                        right = col - 1;
                    } else {
                        return true;
                    }
                }

                return false;
            }
        }

        return false;
    }
}
