class Solution {
    public int differenceOfSums(int n, int m) {
        // List<Integer> nums1 = new ArrayList<>();
        // List<Integer> nums2 = new ArrayList<>();
        int nums1 = 0;
        int nums2 =0;

        for (int i = 1; i <= n; i++) {
            if (i % m == 0) {
                nums1 += i;
            } else {
                nums2 += i;
            }
        }

        // int numSum1 = 0;
        // int numSum2 = 0;

        // for (int num : nums1) numSum1 += num;
        // for (int num : nums2) numSum2 += num;

        return nums2 - nums1;
    }
}