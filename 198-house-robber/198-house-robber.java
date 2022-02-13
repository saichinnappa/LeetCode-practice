class Solution {
    int sum = 0;
    int[] cache = new int[100];
    public int rob(int[] nums) {
        int rob1 = 0, rob2 = 0;
        for(int i = 0; i < nums.length; i++){
            int temp = Math.max(rob1 + nums[i], rob2);
            rob1 = rob2;
            rob2 = temp;
                
        }
        return rob2;
        // Arrays.fill(this.cache, -1);
        // return rob(0, nums);
    }
    
//     int rob(int index, int[] nums){
//         if(index >= nums.length)
//             return 0;
        
//         if(cache[index] > -1)
//             return cache[index];
        
//         int ans = Math.max(rob(index + 1, nums), rob(index + 2, nums) + nums[index]);
//         cache[index] = ans;
//         return ans;
    // }
}