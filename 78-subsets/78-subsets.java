class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        
        for(int k = 0; k < nums.length + 1; k++){
            solve(nums, new ArrayList<>(), k , 0);
        }
        return result;
    }
    
    void solve(int[] nums, List<Integer> list, int k,  int idx){
        if(list.size() == k){
            result.add(new ArrayList<>(list));
            return;
        }
        for(int i = idx; i < nums.length; i++){
            list.add(nums[i]);
            // System.out.println(list);
            solve(nums, list, k, i + 1);
            list.remove(list.size()  - 1);
        }
    }
}

// class Solution {
//     // int n, k;
//     int[] nums;
//     List<List<Integer>> result = new ArrayList();
//     public List<List<Integer>> subsets(int[] nums) {
//         this.nums = nums;
//         // this.n = nums.length;
//         for(int k = 0; k < nums.length + 1; k++){
//             backtrack(0, new ArrayList<>(),k);
//         }
//         return result;
//     }
    
//     void backtrack(int first, List<Integer> list,int k){
//         if(list.size() == k){
//             result.add(new ArrayList(list));
//             return;
//         }
        
//         for(int i = first; i< nums.length; i++){
//             list.add(nums[i]);
//             backtrack(i + 1, list,  k);
//             list.remove(list.size() - 1);
//         }
//     }
// }
    
// }