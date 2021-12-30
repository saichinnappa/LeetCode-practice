class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        if(nums.length == 0)
            return result;
        // if(nums.length == 1 && target == nums[0])
        //     return new int[]{0,0};
        
        boolean firstFound = false;
        for(int i = 0; i< nums.length; i++){
            if(nums[i] == target){
                if(!firstFound){
                    result[0] = i;
                    result[1] = i;
                    firstFound = true;
                }
                else
                    result[1] = i;
            } else if(nums[i] > target && !firstFound){
                break;
            }
            
            
        }
        
        return result;
    }
}