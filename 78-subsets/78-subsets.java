class Solution {
    int n, k;
    int[] nums;
    List<List<Integer>> result = new ArrayList();
    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        for(k = 0; k < n + 1; k++){
            backtrack(0, new ArrayList<>());
        }
        return result;
    }
    
    void backtrack(int first, List<Integer> list){
        if(list.size() == k){
            result.add(new ArrayList(list));
            return;
        }
        
        for(int i = first; i< n; i++){
            list.add(nums[i]);
            backtrack(i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}