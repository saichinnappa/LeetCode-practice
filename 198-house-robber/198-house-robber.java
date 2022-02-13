class Solution {
    int sum = 0;
    int[] cache = new int[100];
    public int rob(int[] nums) {
        
        int n = nums.length;
        if(n==0)
            return 0;
        if(n == 1)
            return nums[0];
        
        int[] dp = new int[n];
        dp[0] = nums[0];        
        dp[1]= Math.max(nums[0],nums[1]);
        for(int i = 2; i < dp.length; i++){
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }
        
        return dp[n - 1];
        
        
//         int rob1 = 0, rob2 = 0;
//         for(int i = 0; i < nums.length; i++){
//             int temp = Math.max(rob1 + nums[i], rob2);
//             rob1 = rob2;
//             rob2 = temp;
                
//         }
//         return rob2;
        // Arrays.fill(this.cache, -1);
        // return rob(0, nums);
    }
    
//     int rob(int index, int[] nums){
//         if(index >= nums.length)
//             return 0;
        
//         if(cache[index] > -1)
//             return cache[index];
        
//         int ans = Math.max(rob(index + 1, nums), rob(index + 2, nums) + nums[index]);
//         cache[index] = ans;
//         return ans;
    // }
}