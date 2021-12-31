class Solution {
    public int removeDuplicates(int[] nums) {
     
//         int k = 0;
//         boolean found = false;

//         for(int i = 0; i < nums.length - 1; i++){
//             if(k != 0 && nums[i] != nums[i + 1]){
//                 nums[k] = nums[i + 1];
//                 k++;
//             } else if(nums[i] == nums[i+1]){
//                 if(!found){
//                     k = i + 1;
//                     found = true;
//                 }
//             }
//         }
//         return k == 0 ? nums.length : k;
        
        int i = 0;
        for(int j = 0; j < nums.length; j++){
            if(nums[i] != nums[j]){
                i++;
                nums[i] = nums[j];
            }
        }
        
        return i + 1;
    }
}