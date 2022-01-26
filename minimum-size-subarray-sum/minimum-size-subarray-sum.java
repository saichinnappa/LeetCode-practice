class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int result = Integer.MAX_VALUE;
        
        int runningSum = 0;
        int start=0;
        for(int i = 0;i < nums.length; i++){
            runningSum += nums[i];
            while(runningSum >= target){
                result = Math.min(result, i - start + 1);
                runningSum -= nums[start];
                start++;
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}