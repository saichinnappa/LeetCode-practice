class Solution {
    List<List<Integer>> result = new ArrayList<>();
    int[] candidates;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        this.candidates = candidates;
        helper(list, target, 0);
        return result;
    }
    
    void helper(List<Integer> list, int target, int index){
        if(target == 0){
            result.add(new ArrayList<>(list));
            return;
        }
        if(target < 0)
            return;
        
        for(int i = index; i < candidates.length; i++){
            list.add(candidates[i]);
            helper(list, target - candidates[i], i);
            list.remove(list.size() -  1);
        }
    }
}