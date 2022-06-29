class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        solve(candidates, target, 0, new ArrayList<>(), 0);
        return result;
    }
    
    void solve(int[] nums, int target, int sum, List<Integer> list, int idx){
        if(sum == target){
            result.add(new ArrayList<>(list));
            return;
        }
        for(int i = idx; i < nums.length;i++){
                 
            list.add(nums[i]);
            sum += nums[i];
    if(sum <= target){
            solve(nums, target, sum, list, i);
                 }
        
            sum -= nums[i];
            list.remove(list.size() - 1);
        }
        
    }
}