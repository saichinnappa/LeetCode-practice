class Solution {
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length - 1; i++){
            int j = i + 1;
            int k = nums.length - 1;
            if(!set.contains(nums[i])){
                set.add(nums[i]);
                while(j < k){
                    int sum = nums[i] + nums[j] + nums[k];
                    if(sum == 0){
                        list.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        while(j < k){
                            if((j + 1) < nums.length && nums[j] == nums[j + 1]){
                                j++;
                            } else{
                                break;
                            }
                        }
                        j++;
                        k--;
                    }
                    else if (sum > 0){
                        k--;
                    } else {
                        j++;
                    }

                }
            }
        }
        return list;
        
    }
}