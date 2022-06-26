class Solution {
    int[] nums;
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.nums = candidates;
        solve(0, target, 0, new ArrayList<>());
        return result;
    }
    
    void solve(int sum, int target, int index, List<Integer> list){
        if(sum == target){
            result.add(new ArrayList(list));
        }
        for(int i = index; i < nums.length; i++){
            sum += nums[i];
            list.add(nums[i]);
            if(sum <= target)
                solve(sum, target, i, list);
            sum -= nums[i];
            list.remove(list.size() - 1);
        }
        
    }
}