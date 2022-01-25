class Solution {
    public int findPeakElement(int[] nums) {
//         if(nums.length == 1)
//             return 0;
//         if(nums.length == 2){
//             if(nums[0] > nums[1])
//                 return 0;
//             else
//                 return 1;
//         }
        
        
//         if(nums.length > 2){
//             if(nums[0] > nums[1]) return 0;
//             else if (nums[nums.length - 1] > nums[nums.length - 2]) return nums.length - 1;
//         }
        
        
        
//         int index = -1;
// //         int val = Integer.MIN_VALUE;
// //         for(int i = 0; i< nums.length; i++){
// //             if(nums[i] > val){
// //                 index = i;
// //                 val = nums[i];
// //             }
                
// //         }
        
//         for(int i = 1; i< nums.length; i++){
//             if(i + 1 < nums.length && nums[i] > nums[i - 1] && nums[i] > nums[i + 1])
//                 return i;
//             else if (i == nums.length - 1 && index == -1)
//                 return i;
            
//         }
        
//             return index;
        
        
        if(nums.length == 1)
            return 0;
        
        return binarySearch(0, nums.length - 1, nums);
    }
    
    
    int binarySearch(int left, int right, int[] nums){
        if(left == right)
            return left;
        int mid = (left + right) / 2;
        if(nums[mid] > nums[mid + 1]){
            return binarySearch(0, mid, nums);
        } else{
            return binarySearch(mid + 1, right, nums);
        }
    }
}