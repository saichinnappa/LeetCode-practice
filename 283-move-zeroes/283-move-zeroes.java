class Solution {
    public void moveZeroes(int[] nums) {
        // int[] result = new int[nums.length];
        int j= 0;
        for(int i = 0; i< nums.length; i++){
            if(nums[i] != 0){
                nums[j] = nums[i];
                j++;
            }
        }
        while(j !=nums.length){
            nums[j] = 0;
            j++;
        }
    }
}