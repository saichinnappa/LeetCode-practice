class Solution {
    List<List<Integer>> result = new ArrayList();
    int[] nums;
    Set<Integer> set = new HashSet();
    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        solve(nums, new ArrayList());
        return result;
    }
    
    boolean isValid(List<Integer> list){
        if(list.size() == nums.length)
            return true;
        return false;
    }
    
    List<Integer> getCandidates(List<Integer> input){
        List<Integer> list = new ArrayList();
        for(int n : nums){
            if(!input.contains(n)){
                list.add(n);
            }
        }
        return list;
    }
    
    void solve(int[] nums, List<Integer> list){
        if(isValid(list)){
            result.add(new ArrayList(list));
        }
        
        List<Integer> candidates = getCandidates(list);
        for(int i = 0; i< candidates.size(); i++){
            list.add(candidates.get(i));
            solve(nums,list);
            list.remove((Integer)candidates.get(i));
        }
        
    }
        
}