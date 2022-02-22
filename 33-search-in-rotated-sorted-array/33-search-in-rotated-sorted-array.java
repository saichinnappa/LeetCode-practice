class Solution {
    int target;
    public int search(int[] nums, int target) {
        this.target = target;
        if(nums.length == 1){
            if(nums[0] == target)
                return 0;
            else
                return -1;
        }
        
        int start = 0;
        int end = nums.length - 1;
        
        if(nums[start] < nums[end]){
            return binarySearch(nums, start, end);
        }
        
        int rotatedIndex = findRotatedIndex(nums, start, end);
        if(nums[rotatedIndex] == target) return rotatedIndex;
        if(target <= nums[end]) return binarySearch(nums, rotatedIndex + 1, end);
        if(target > nums[end]) return binarySearch(nums, start, rotatedIndex - 1);
        
        
        return -1;
    }
    
    
    int binarySearch(int[] nums, int start, int end){

        while(start <= end){
            int mid = start + (end - start) / 2;
            if(nums[mid] == target)
                return mid;
            if(nums[mid] > target){
                end = mid - 1; 
            }
            else
                start = mid + 1;
        }
        
        return -1;
    }
    
    int findRotatedIndex(int[] nums, int start, int end){
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(nums[mid] > nums[mid + 1])
                return mid + 1;
            if(nums[mid] < nums[mid - 1])
                return mid;
            if(nums[mid] > nums[start]){
                start = mid + 1;
            } else if (nums[mid] < nums[start])
                end = mid -1;
        }
        return -1;
    }
    
    
    
}