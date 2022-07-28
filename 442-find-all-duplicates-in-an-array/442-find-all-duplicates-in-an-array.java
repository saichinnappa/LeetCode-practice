class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        
        List<Integer> result = new ArrayList<>();
        for(int n : nums){
            
            if(nums[Math.abs(n) - 1] < 0){
                result.add(Math.abs(n));
            }
            nums[Math.abs(n)- 1] *= -1;
        }
        return result;
    }
}