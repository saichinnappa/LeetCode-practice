class Solution {
    public int numIdenticalPairs(int[] nums) {
        int result = 0;
        for(int i = 1; i < nums.length; i++){
            int j = 0;
            while(j < i){
                if(nums[i] == nums[j]){
                    result++;
                }
                j++;
            }
        }
            
         return result;   
    }
}