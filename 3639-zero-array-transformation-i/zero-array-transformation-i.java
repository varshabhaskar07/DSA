class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        // creating a difference array
        int[] count = new int[n+1]; 
        for(int[] q : queries){
            int l = q[0], r = q[1];
            count[l] += 1;
            if(r+1 < n){
                count[r+1] -=1;
            }
        }

        int current = 0;
        for(int i =0;i<n ; i++){
            current+= count[i];
            if(nums[i] >current){
                return false;
            }
        }
        return true;
    }
}