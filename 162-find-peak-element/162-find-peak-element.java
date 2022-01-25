class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1)
            return 0;
        if(nums.length == 2){
            if(nums[0] > nums[1])
                return 0;
            else
                return 1;
        }
        
        
        int index = -1;
        int val = Integer.MIN_VALUE;
        for(int i = 0; i< nums.length; i++){
            if(nums[i] > val){
                index = i;
                val = nums[i];
            }
                
        }
        
//         for(int i = 1; i< nums.length; i++){
//             if(i + 1 < nums.length && nums[i] > nums[i - 1] && nums[i] > nums[i + 1])
//                 return i;
//             else if (i == nums.length - 1 && index == -1)
//                 return i;
            
//         }
        
            return index;
    }
}