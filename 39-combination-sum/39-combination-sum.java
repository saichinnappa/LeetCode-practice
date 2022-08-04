class Solution {
    List<List<Integer>> result = new ArrayList<>();
    int[] nums;
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.nums = candidates;
        solve(0, new ArrayList<>(), target, 0);
        return result;
    }
    
    
    void solve(int sum, List<Integer> list, int target, int idx){
        if(sum == target){
            result.add(new ArrayList<>(list));
            return;
        }
        
        for(int i = idx; i < nums.length; i++){
            sum += nums[i];
            list.add(nums[i]);
            if(sum <= target){
                solve(sum, list, target, i);
            }
            sum -= list.get(list.size() - 1);
            list.remove(list.size() - 1);
            // solve(sum, list, target, i + 1);
        }
    }
    
    
}