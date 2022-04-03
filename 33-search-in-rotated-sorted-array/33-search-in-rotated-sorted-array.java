class Solution {
    int[] nums;
    int target;
    int length;
    public int search(int[] nums, int target) {
        this.length = nums.length ;
        this.nums = nums;
        this.target = target;
        int start = 0;
        int end = nums.length - 1;
                if(nums.length == 1){
            if(nums[0] == target)
                return 0;
            else
                return -1;
        }
        if(nums[start] < nums[end]){
            return binarySearch(start, end);
        }
        
        int rIdx = rotatedIndex(start, end);
        if(nums[rIdx] == target)
            return rIdx;
        if(nums[end] >= target)
            return binarySearch(rIdx + 1, end);
        if(nums[end] < target)
            return binarySearch(start, rIdx - 1);
        
            return -1;
            
            
    }
    
    
    int binarySearch(int start, int end){
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(nums[mid] == target)
                return mid;
            if(nums[mid] > target){
                end = mid - 1;
            } else{
                start = mid + 1;
            }
        }
        return -1;
    }
    
    // int rotatedIndex(int start, int end){
    //     while(start <= end){
    //         int mid = start + (end - start) / 2;
    //         if(nums[mid] > nums[mid + 1])
    //             return mid + 1;
    //         if(nums[mid] < nums[mid - 1])
    //             return mid;
    //         if(nums[mid] > nums[start])
    //             start = mid + 1;
    //         else if (nums[mid] < nums[end])
    //             end = mid - 1;
    //     }
    //     return -1;
    // }
    
       int rotatedIndex(int start, int end){
        while(start <= end){
            int mid = (start) + (end - start) /2 ;
            if(nums[mid] > nums[mid + 1])
                return mid + 1;
            else if(nums[mid] < nums[mid - 1])
                return mid;
            else if (nums[mid] > nums[start]){
                start = mid + 1;
            } else if(nums[mid] < nums[end])
                end = mid - 1;
        }
        return -1;
    }
    
    
    
}