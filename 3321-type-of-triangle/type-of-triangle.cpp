class Solution {
public:
    string triangleType(vector<int>& nums) {
        int a = nums[0], b = nums[1], c = nums[2];
        if(a+b <= c|| a+c <= b || c+b <=a){
            return "none";
        }

        else if(a == b && b==c){
            return "equilateral";
        }
        else if(a!=b && b!= c && a!=c){
            return "scalene";
        }
        else{
            return "isosceles";
        }

    }
};