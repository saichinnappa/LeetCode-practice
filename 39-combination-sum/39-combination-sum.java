class Solution {
    List<List<Integer>> result = new ArrayList<>();
    int[] candidates;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        List<Integer> list = new ArrayList<>();
        helper(target, 0, list);
        return result;
    }
    
    void helper(int target, int index, List<Integer> list){
        if(target == 0){
            result.add(new ArrayList<>(list));
            return;
        }
        if(target < 0)
            return;
        
        for(int i = index; i < candidates.length; i++){
            list.add(candidates[i]);
            helper(target - candidates[i], i, list);
            list.remove(list.size() - 1);
        }
    }
}