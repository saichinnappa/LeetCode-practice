class Solution {
    public int majorityElement(int[] nums) {
        
        if(nums.length == 1)
            return nums[0];
     
        int major = nums[0];
        int count = 1;
        
        for(int i = 1; i< nums.length; i++){
            if(major == nums[i])
                count++;
            else{
                count--;
                if(count == 0){
                    major  = nums[i];
                    count = 1;
                }
            }
        }
        
        return major;
        
    }
}