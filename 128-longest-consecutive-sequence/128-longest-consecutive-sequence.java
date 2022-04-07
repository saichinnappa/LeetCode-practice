class Solution {
    public int longestConsecutive(int[] nums) {
        // if(nums.length < 2)
        //     return nums.length;
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

// class Solution {
//     public int longestConsecutive(int[] nums) {
//         Set<Integer> num_set = new HashSet<Integer>();
//         for (int num : nums) {
//             num_set.add(num);
//         }

//         int longestStreak = 0;

//         for (int num : num_set) {
//             if (!num_set.contains(num-1)) {
//                 int currentNum = num;
//                 int currentStreak = 1;

//                 while (num_set.contains(currentNum+1)) {
//                     currentNum += 1;
//                     currentStreak += 1;
//                 }

//                 longestStreak = Math.max(longestStreak, currentStreak);
//             }
//         }

//         return longestStreak;
//     }
// }