class Solution {
    public int removeDuplicates(int[] nums) {
     
        int k = 0;
        
        for(int i = 0; i< nums.length - 1; i++){
            if(nums[i] == nums[i+1]){
                k = i + 1;
                break;
            }
        }
        
        if(k != 0){
            for(int i = k; i < nums.length - 1; i++){
                if(nums[i] != nums[i + 1]){
                    nums[k] = nums[i + 1];
                    k++;
                }
            }
        }
        
        return k == 0 ? nums.length : k;
        
    }
}