class Solution {
    int target = 0;
    public int search(int[] nums, int target) {
        this.target = target;
        
        if(nums.length == 1){
            if(target == nums[0])
                return 0;
            else
                return -1;
        }
        
        int length = nums.length - 1;
        int rIdx = findRotatedIndex(nums, 0, length);
        if(nums[rIdx] == target)
            return rIdx;
        
        if(rIdx == 0)
            return binarySearch(nums, 0 , length);
        
        if(target <= nums[length]){
            return binarySearch(nums, rIdx + 1, length);
        } else{
            return binarySearch(nums, 0, rIdx - 1);
        }
            
}

    private int binarySearch(int[] nums, int start, int end){
        while(start <= end){
            int mid = (start + end) /2;
            if(nums[mid]  == target)
                return mid;
            if(nums[mid] < target){
                start = mid + 1;
            } else if (nums[mid] > target){
                end = mid - 1;
            }
        }
        return -1;
    }
    
    
    
    int findRotatedIndex(int[] nums, int start, int end){
        if(nums[start] < nums[end])
            return 0;

        while(start <= end){
            int mid = (start + end) /2;
            if(nums[mid] > nums[mid + 1])
                return mid + 1;
            if(nums[mid] < nums[mid - 1])
                return mid;
             if (nums[mid] >= nums[start])
                start = mid + 1;
            else if (nums[mid] < nums[start])
                end = mid - 1;
        }

        return -1;
    }
}