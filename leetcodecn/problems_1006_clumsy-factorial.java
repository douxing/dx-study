class Solution {
    public int clumsy(int N) {
        switch (N) {
            case 1: return 1;
            case 2: return 2;
            case 3: return 6;
            case 4: return 7;
            default: break;
        }
        int sum = N * (N - 1) / (N - 2) + N - 3;
        int i = N - 4;
        while (i >= 4) {
            sum += i - 3 - ((i) * (i - 1) / (i - 2));
            i -= 4;
        }
        switch (i) {
            case 0: break;
            case 1: sum -= 1; break;
            case 2: sum -= 2; break;
            case 3: sum -= 6; break;
        }
        return sum;
    }
}
