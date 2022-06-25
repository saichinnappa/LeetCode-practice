class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(!set.contains(nums[i])){
                set.add(nums[i]);
                int j = i + 1;
                int k = nums.length - 1;
                while(j < k){
                    int sum = nums[i] + nums[j] + nums[k];
                    if(sum == 0){

                        result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        while(j < k){
                            if(nums[j] == nums[j + 1]){
                                j++;
                            } else{
                                break;
                            }
                        }
                        j++;
                        k--;
                    } else if(sum > 0){
                        k--;
                    } else{
                        j++;
                    }
                }
            }
        }
        return result;
    }
}