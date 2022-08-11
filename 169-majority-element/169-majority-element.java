class Solution {
    public int majorityElement(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        int v = nums[0];
        int count = 1;
        for(int i = 1; i< nums.length; i++){
            if(nums[i] == v)
                count++;
            else{
                count--;
            }
            if(count == 0){
                v = nums[i];
                count++;
            }
        }
        
        return v;
    }
}