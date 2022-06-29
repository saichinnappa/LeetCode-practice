class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        for(int i = 0; i < nums.length +1; i++){
            solve(i, nums, new ArrayList<>(), 0);
        }
        return result;
    }
    
    void solve(int k, int[] nums, List<Integer> list, int idx){
        if(list.size() == k)
            result.add(new ArrayList<>(list));
        for(int i =idx; i < nums.length; i++){
            list.add(nums[i]);
            solve(k, nums, list, i+ 1);
            list.remove(list.size() -1);
        }
    }
}