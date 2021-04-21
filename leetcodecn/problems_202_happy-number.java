class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet();
        while (!set.contains(n)) {
            set.add(n);
            int total = 0;
            while (n > 0) {
                total += (n % 10) * (n % 10);
                n /= 10;
            }
            if (total == 1) {
                return true;
            }
            n = total;
        }
        return false;
    }
}
