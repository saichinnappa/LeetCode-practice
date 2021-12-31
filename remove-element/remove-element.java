class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0;
        
        //find first index
        for(int i = 0; i< nums.length; i++){
            if(nums[i] == val){
                k = i;
                break;
            }
        }
        
        for(int j = k; j < nums.length; j++){
            if(nums[j] != val){
                nums[k] = nums[j];
                k++;
            }
        }
        return k;
    }
}