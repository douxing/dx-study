class Solution {
    public int candy(int[] ratings) {
        if (ratings.length == 0) return 0;
        int[] res = new int[ratings.length];
        res[0] = 1;
        for (int i = 1; i < ratings.length; i += 1) {
            if (ratings[i] > ratings[i - 1]) {
                res[i] = res[i - 1] + 1;
            } else if (ratings[i] < ratings[i - 1]) {
                res[i] = 1;
                for (int j = i; j >= 1; j -= 1) {
                    int k = j - 1;
                    if (ratings[k] > ratings[j]) {
                        res[k] = Math.max(res[j] + 1, res[k]);
                    } else {
                        break;
                    }
                }
            } else { // equal
                res[i] = 1;
            }
        }
        int c = 0;
        for (int r: res) {
            c += r;
        }
        return c;
    }
}
