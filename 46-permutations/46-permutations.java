class Solution {
    List<List<Integer>> result = new ArrayList<>();
    int[] nums;
    Set<Integer> set = new HashSet<>();
    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        solve(new ArrayList<>());
        return result;
    }
    
    
    List<Integer> getCandidates(){
        List<Integer> candidates = new ArrayList<>();
        for(int n : nums){
            if(!set.contains(n)){
                candidates.add(n);
            }
        }
        
        return candidates;
    }
    
    void solve(List<Integer> list){
        if(list.size() == nums.length){
            result.add(new ArrayList<>(list));
            return;
        }
        List<Integer> candidates = getCandidates();
        for(int n : candidates){
            set.add(n);
            list.add(n);
            solve(list);
            set.remove(n);
            list.remove(list.size() - 1);
        }
    }
}