class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        
        Set<Integer> set = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        if(nums.length == 1)
            return result;
        for(int n : nums){
            if(!set.contains(n))
                set.add(n);
            else
                result.add(n);
        }
        return result;
    }
}