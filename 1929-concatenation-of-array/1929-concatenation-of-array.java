class Solution {
    public int[] getConcatenation(int[] nums) {
        
        int n = nums.length;
        int[] ans = new int[2 * n];
        
        // for(int i = 0; i < ans.length; i++){
        //     if(i > n - 1){
        //         ans[i] = nums[i - n];
        //     } else{
        //         ans[i] = nums[i];
        //     }
        // }
        System.arraycopy(nums, 0, ans, 0, n);
        System.arraycopy(nums, 0, ans, n, n);
        return ans;
    }
}