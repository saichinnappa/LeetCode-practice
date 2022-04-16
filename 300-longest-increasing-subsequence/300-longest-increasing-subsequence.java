class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int[] dp = new int[nums.length];
        Arrays.setAll(dp, i -> 1);
        int result = 1;
        
        for(int i = 0; i < nums.length; i++){
            int j = 0;
            while(j < i){

                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                    // System.out.println(nums[i]+" -> "+ dp[i]);
                    result = Math.max(result, dp[i]);
                }
                                j++;
                // System.out.println("****");
            }
        }
        return result;
    }
}