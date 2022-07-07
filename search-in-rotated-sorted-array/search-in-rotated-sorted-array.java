class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        
         if(nums.length == 1){
            if(nums[0] == target)
                return 0;
            else
                return -1;
        }
        
        if(nums[start] < nums[end]){
            return binarySearch(nums, start, end, target);
        }
        
        int rIdx = rotatedIdx(nums, start, end);
        if(nums[rIdx] == target)
            return rIdx;
        if(nums[end] < target){
            return binarySearch(nums, start, rIdx - 1, target);
        } else{
            return binarySearch(nums, rIdx + 1, end, target);
        }
        
        
    }
    
    int rotatedIdx(int[] nums, int start, int end){
        while(start <= end){
            int mid = (start + end) /2;
            if(nums[mid] > nums[mid + 1])
                return mid + 1;
            if(nums[mid] < nums[mid - 1])
                return mid;
            if(nums[mid] > nums[end]){
                start = mid + 1;
            } else{
                end = mid - 1;
            }
        }
        return -1;
    }
    
    
    int binarySearch(int[] nums, int start, int end, int target){
        while(start <= end){
            int mid = (start + end) / 2;
            if(nums[mid] > target)
                end = mid - 1;
           else if(nums[mid] < target)
                start = mid + 1;
            else
                return mid;
        }
        return -1;
    }
}