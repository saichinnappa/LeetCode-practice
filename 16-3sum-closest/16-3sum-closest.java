class Solution {
    public int threeSumClosest(int[] nums, int target) {
         if(nums.length < 3)
            return -1;
        int result = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            int j = i + 1;
            int k = nums.length - 1;
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(result == Integer.MAX_VALUE)
                    result = sum;
                if(Math.abs(target - result) > Math.abs(target - sum))
                    result = sum;
                if(target < sum)
                    k--;
                else if(target > sum)
                    j++;
                else
                    return result;
            }
        }
        return result;
    }
}