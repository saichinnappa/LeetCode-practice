class Solution {
    public int majorityElement(int[] nums) {
        int ans = nums[0];
        int count = 1;
        
        if(nums.length == 0) return 0;
        
        for(int i = 1; i < nums.length; i++){
            // if(count == 0)
            //     count = 1;
            if(ans == nums[i]){
                count++;
            } else{
                count--;
            }
            
            if(count == 0){
                ans = nums[i];
                count++;
            }
        }
        
        return ans;
    }
}