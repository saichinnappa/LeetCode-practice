class Solution {
    List<List<Integer>> result = new ArrayList<>();
    int[] candidates;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        solve(0, target, 0, new ArrayList<>());
        return result;
    }
    
    void solve(int index, int target, int sum, List<Integer> list){
        if(sum == target){
            result.add(new ArrayList<>(list));
            return;
        }
        for(int i = index; i< candidates.length; i++){
            sum += candidates[i];
            list.add(candidates[i]);
            if(sum <= target){
                solve(i, target, sum, list);
            }
            sum -= candidates[i];
            list.remove(list.size() - 1);    
            
            
        }
    }
}