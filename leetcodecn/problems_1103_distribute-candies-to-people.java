class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int[] dist = new int[num_people];
        int base = 0;
        while (true) {
            for (int slot = 0; slot < num_people; slot += 1) {
                int d = base + slot + 1;
                if (candies > d) {
                    candies -= d;
                    dist[slot] += d;
                } else {
                    dist[slot] += candies;
                    return dist;
                }
            }
            base += num_people;
        }
    }
}
