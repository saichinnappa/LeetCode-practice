class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int result = Integer.MAX_VALUE;
        int i = 0;
        Arrays.sort(nums);
        while(i < nums.length){
            int j = i + 1;
            int k = nums.length - 1;
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(Math.abs(target-sum) < Math.abs(result)){
                    result = target - sum;
                }
                if (sum > target){
                    k--;
                } else{
                    j++;
                }
            }
            i++;
        }
        return target - result;
    }
}