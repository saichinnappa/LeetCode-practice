class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        solve(0, new ArrayList<>(), nums);
        return result;
    }
    
    void solve(int idx, List<Integer> list, int[] nums){
        if(list.size() <= nums.length){
            result.add(new ArrayList<>(list));
        }
        for(int i = idx; i< nums.length; i++){
            list.add(nums[i]);
            solve(i + 1, list, nums);
            list.remove(list.size() - 1);
        }
    }
}