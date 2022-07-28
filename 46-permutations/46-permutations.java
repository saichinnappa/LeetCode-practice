// class Solution {
//     List<List<Integer>> result = new ArrayList<>();
//     int[] nums;
//     Set<Integer> set = new HashSet<>();
//     public List<List<Integer>> permute(int[] nums) {
//         this.nums = nums;
//         solve(new ArrayList<>());
//         return result;
//     }
    
    
//     List<Integer> getCandidates(){
//         List<Integer> candidates = new ArrayList<>();
//         for(int n : nums){
//             if(!set.contains(n)){
//                 candidates.add(n);
//             }
//         }
        
//         return candidates;
//     }
    
//     void solve(List<Integer> list){
//         if(list.size() == nums.length){
//             result.add(new ArrayList<>(list));
//             return;
//         }
//         List<Integer> candidates = getCandidates();
//         for(int n : candidates){
//             set.add(n);
//             list.add(n);
//             solve(list);
//             set.remove(n);
//             System.out.println("Removing: "+ list.get(list.size() - 1));
//             list.remove(list.size() - 1);
//         }
//     }
// }

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> _nums = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            _nums.add(nums[i]);
        }
        return permutation(_nums);

    }

    public List<List<Integer>> permutation(LinkedList<Integer> nums) {
        List<List<Integer>> res = new ArrayList<>();

        if (nums.size() == 1) {
            res.add(new ArrayList<>(nums));
            return res;
        }

        for (int i = 0; i < nums.size(); i++) {
            int num = nums.pollFirst();

            List<List<Integer>> permutations = permutation(nums);
            for (List<Integer> perm : permutations) {
                perm.add(num);
            }

            res.addAll(permutations);

            nums.addLast(num);

        }

        return res;
    }
}