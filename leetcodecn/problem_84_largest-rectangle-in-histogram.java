class Solution {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len == 0) {
            return 0;
        } else if (len == 1) {
            return heights[0];
        }

        Deque<Integer> stack = new ArrayDeque();
        stack.addLast(0);
        int max = heights[0];
        for (int i = 1; i < heights.length; i += 1) {
            if (stack.size() == 0) {
                stack.addLast(i);
                continue;
            }

            int j = stack.peekLast();
            int hj = heights[j];
            int hi = heights[i];

            if (hi >= hj) {
                stack.addLast(i);
            } else if (hi < hj) {
                while (true) {
                    stack.removeLast();
                    if (stack.size() == 0) {
                        max = Math.max(max, i * hj);
                        stack.addLast(i);
                        break;
                    } else {
                        int nextj = stack.peekLast();
                        max = Math.max(max, (i - nextj - 1) * hj);
                        j = nextj;
                        hj = heights[j];
                        if (hi >= hj) {
                            stack.addLast(i);
                            break;
                        }
                    }
                }
            }
        }

        while (stack.size() > 1) {
            int j = stack.peekLast();
            int hj = heights[j];
            stack.removeLast();
            max = Math.max(max, (len - 1 - stack.peekLast()) * hj);
            //System.out.println("" + j + " " + hj + " " + max);
        }

        if (stack.size() == 1) {
            int j = stack.removeLast();
            int hj = heights[j];
            max = Math.max(max, len * hj);
            //System.out.println("" + j + " " + hj + " " + max);
        }

        return max;
    }
}
