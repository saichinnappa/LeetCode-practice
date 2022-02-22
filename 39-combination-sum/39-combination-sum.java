class Solution {
    List<List<Integer>> result = new ArrayList();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> list = new ArrayList();
        solve(candidates, target, list, 0);
        return result;    
    }
    
    
    void solve(int[] candidates, int target, List<Integer> list, int index){
        if(target == 0){
            result.add(new ArrayList<>(list));
            return;
        } else if (target < 0){
            return;
        }
        
        for(int i = index; i < candidates.length; i++){
            list.add(candidates[i]);
            solve(candidates, target - candidates[i], list, i);
            list.remove(list.size() - 1);
        }
        
    }
    
}