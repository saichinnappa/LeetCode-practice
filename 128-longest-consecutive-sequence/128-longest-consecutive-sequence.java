class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length < 2)
            return nums.length;
        Set<Integer> set = new HashSet<>();
        int maxStreak = 0;
        for(int num : nums)
            set.add(num);
        
        for(int i = 0; i < nums.length; i++){
            int current = nums[i];
            if(!set.contains(current - 1)){
                int count = 1;
                while(set.contains(current + 1)){
                    current++;
                    count++;
                }
                maxStreak = Math.max(maxStreak, count);
            }
        }
        
        return maxStreak;
    }
}