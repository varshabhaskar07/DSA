class Solution {
public:
    void sortColors(vector<int>& nums) {
        int n = nums.size();
        int low = 0, mid = 0 , high = n-1;  
        while(mid <= high){
            if(nums[mid] == 0){
                swap(nums[low],nums[mid]);
                mid++;
                low++;
            }
            else if( nums[mid] == 1){
                // swap(nums[low],nums[mid]);
                mid++;
                
            }
            else{
                swap(nums[high], nums[mid]);
                high--;
            }
        }



        // int n = nums.size();
        // int a= 0 ;
        // int b = 0 ;
        // int c = 0 ;

        // for(int i = 0; i< n; i++){
        //     if(nums[i] == 0){
        //         a++;
        //     }
        //     if(nums[i] == 1){
        //         b++;
        //     }
        //     else if(nums[i] == 2){
        //         c++;
        //     }
        // }
        // for(int i = 0; i< a; i++){
        //     nums[i] = 0;
            
        // }
        // for(int i = a; i<(a+b);i++){
        //     nums[i] = 1;
        // }
        // for(int i = a+b; i<(a+b+c);i++){
        //     nums[i] = 2;
        // }
        
    }
};