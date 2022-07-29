class Solution {
    List<List<Integer>> result = new ArrayList<>();
    int[] nums;
    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        backtrack(0, new ArrayList<>());
        return result;
    }
    
    
    void backtrack(int idx, List<Integer> list){
        if(list.size() <= nums.length){
            result.add(new ArrayList<>(list));
        }
        for(int i = idx; i < nums.length; i++){
            list.add(nums[i]);
            backtrack(i + 1, list);
            list.remove(list.size() - 1);
        }
    }
    
}