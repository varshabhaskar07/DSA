class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        int n = nums.length;
        long totalSum = 0;
        int countGainPositive = 0;
        int minDifference = Integer.MAX_VALUE;

        for (int num : nums) {
            int xorValue = num ^ k;
            int gain = xorValue - num;

            totalSum += num;

            if (gain > 0) {
                totalSum += gain;
                countGainPositive++;
            }

            minDifference = Math.min(minDifference, Math.abs(gain));
        }

        // If the number of positive gains is even, all are valid
        if (countGainPositive % 2 == 0) {
            return totalSum;
        } else {
            // Remove the smallest gain to make count even
            return totalSum - minDifference;
        }
    }
}