class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int n = candidates.length;
        // if(n == 1 && target != candidates[0])
        //     return result;
        solve(0, new ArrayList<>(), target, candidates, 0);
        return result;
    }
    
    void solve(int idx, List<Integer> list, int target, int[] nums, int sum){
        if(sum == target){
            result.add(new ArrayList<>(list));
            return;
        }
        for(int i = idx; i < nums.length; i++){
            list.add(nums[i]);
            sum += nums[i];
            if(sum <= target){
                solve(i, list, target, nums, sum);
            }
            sum -= nums[i];
            list.remove(list.size() - 1);
        }
    }
}