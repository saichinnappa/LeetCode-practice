class Solution {
    public void rotate(int[] nums, int k) {
        
        k %= nums.length;
        int i = 0;
        int j = nums.length - 1;
        
        reverse(nums, i , j);
        reverse(nums, i , k - 1);
        reverse(nums, k , j);
        
    }
    
    
    void reverse(int[] nums, int i, int j){
        while(i <j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}