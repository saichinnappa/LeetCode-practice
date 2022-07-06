class Solution {
    List<List<Integer>> result = new ArrayList<>();
    Set<Integer> set = new HashSet<>();
    public List<List<Integer>> permute(int[] nums) {
        
        solve(0, new ArrayList<>(), nums);
        return result;
    }
    
    List<Integer> getCandidates(int[] nums){
        List<Integer> list = new ArrayList<>();
        for(int n : nums){
            if(!set.contains(n)){
                list.add(n);
            }
        }
        return list;
    }
    
    void solve(int idx, List<Integer> list, int[] nums){
        if(list.size() == nums.length){
            result.add(new ArrayList<>(list));
            return;
        }
        
        List<Integer> candidates = getCandidates(nums);
        for(int n : candidates){
            set.add(n);
            list.add(n);
            solve(idx, list, nums);
            set.remove(n);
            list.remove(list.size() - 1);
        }
    }
}