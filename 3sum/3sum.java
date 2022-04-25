class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length == 0)
            return result;
        Arrays.sort(nums);
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(!set.contains(nums[i])){
                int j = i + 1;
                int k = nums.length - 1;
                
                while(j < k){
                    List<Integer> list = new ArrayList<>();
                    int sum = nums[i] + nums[j] + nums[k];
                    if(sum == 0){
                        list.addAll(Arrays.asList(nums[i], nums[j], nums[k]));
                        while(j < n - 1 && nums[j] == nums[j + 1]){
                            j++;
                        }
                        j++;
                        k--;
                    } else if(sum > 0){
                        k--;
                    } else{
                        j++;
                    }
                if(list.size() > 0)
                    result.add(list);
                }
                set.add(nums[i]);

            }
        }
        return result;
    }
}