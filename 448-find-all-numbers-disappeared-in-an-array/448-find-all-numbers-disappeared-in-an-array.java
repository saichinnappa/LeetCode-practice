class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList();
        Set<Integer> set = new HashSet();
        for(int n : nums){
            set.add(n);
        }
        
        for(int i= 1; i < nums.length + 1; i++){
            if(!set.contains(i))
                result.add(i);
        }
        
        return result;
    }
}