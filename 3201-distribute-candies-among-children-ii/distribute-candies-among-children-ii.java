class Solution {
    public long distributeCandies(int n, int limit) {
        if (n > 3 * limit) {
            return 0; // Not possible to distribute if total candies exceed 3 * limit
        }

        long totalWays = combinations(n + 2, 2); // Total ways without limit
        long invalidWays = 0;

        if (n > limit) {
            invalidWays += 3 * combinations(n - limit + 1, 2); // Ways where at least one child exceeds limit
        }
        if(n >= 2*limit + 2){
             invalidWays -= 3 * combinations(n - 2*limit, 2); // Correcting for double subtraction
        }
        

        return totalWays - invalidWays;
    }

    private long combinations(int n, int k) {
        if (k < 0 || k > n) {
            return 0;
        }
        long res = 1;
        for (int i = 0; i < k; i++) {
            res = res * (n - i) / (i + 1);
        }
        return res;
    }
}