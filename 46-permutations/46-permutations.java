// class Solution {
//     Set<Integer> set = new HashSet<Integer>();
//     List<List<Integer>> result = new ArrayList<>();
//     int[] nums;
//     public List<List<Integer>> permute(int[] nums) {
//         this.nums = nums;
//         solve(new ArrayList());
//         return result;
//     }
    
//     List<Integer> getCandidates(){
//         List<Integer> list = new ArrayList<>();
//         for(int n : nums){
//             if(!set.contains(n))
//                 list.add(n);
//         }
//         return list;
//     }
    
    
//     void solve(List<Integer> list){
//         if(list.size() == nums.length){
//             result.add(new ArrayList<>(list));
//         }
        
//         List<Integer> candidates = getCandidates();
        
//         for(int n : candidates){
//             set.add(n);
//             list.add(n);
//             solve(list);
//             set.remove(n);
//             list.remove(list.size() - 1);
//         }
//     }
// }

class Solution {
  public void backtrack(int n,
                        ArrayList<Integer> nums,
                        List<List<Integer>> output,
                        int first) {
    // if all integers are used up
    if (first == n)
      output.add(new ArrayList<Integer>(nums));
    for (int i = first; i < n; i++) {
      // place i-th integer first 
      // in the current permutation
      Collections.swap(nums, first, i);
      // use next integers to complete the permutations
      backtrack(n, nums, output, first + 1);
      // backtrack
      Collections.swap(nums, first, i);
    }
  }

  public List<List<Integer>> permute(int[] nums) {
    // init output list
    List<List<Integer>> output = new LinkedList();

    // convert nums into list since the output is a list of lists
    ArrayList<Integer> nums_lst = new ArrayList<Integer>();
    for (int num : nums)
      nums_lst.add(num);

    int n = nums.length;
    backtrack(n, nums_lst, output, 0);
    return output;
  }
}