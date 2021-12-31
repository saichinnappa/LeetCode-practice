class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        
        if(nums.length == 0)
            return result;
        
        Arrays.sort(nums);
        Set<Integer> set = new HashSet();
        
        // int j = 0, k = nums.length - 1;
        
        for(int i = 0; i< nums.length; i++){
            if(!set.contains(nums[i])){
                set.add(nums[i]);
                List<Integer> list= new ArrayList();
                int j = i + 1, k = nums.length - 1;
                while(j < k){
                    int sum = nums[i] + nums[j] + nums[k];
                    if(sum == 0){
                        result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        j++;
                        k--;
                        while(j < k && nums[j] == nums[j - 1]){
                            j++;
                        } 

                    } else if (sum > 0){
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