class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length == 0)
            return result;
        Arrays.sort(nums);
        Set<Integer> set = new HashSet();
        for(int i = 0; i < nums.length; i++){
            if(!set.contains(nums[i])){
                set.add(nums[i]);
                int j = i + 1;
                int k = nums.length - 1;
                while(j < k) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if(sum == 0){
                        result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        j++;
                        k--;
                        while(j < k){
                            if(j < nums.length && nums[j] == nums[j - 1])
                                j++;
                            else{
                                break;
                            }
                        }
                    } else if(sum < 0){
                        j++;
                    } else{
                        k--;
                    }
                }
            }
        }
        return result;
    }
}
