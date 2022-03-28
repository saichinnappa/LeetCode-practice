class Solution {
    int[] nums;
    int target;
    public int search(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        int n = nums.length -1;
        if(nums.length == 1){
            if(nums[0] == target)
                return 0;
            else
                return -1;
        }
        if(nums[0] < nums[n]){
            return binarySearch(0, n);
        }
        
        
        int rIdx = findRotatedIndex(0, n);
        System.out.println(rIdx);
        if(nums[rIdx] == target)
            return rIdx;
         if(target <= nums[n])
            return binarySearch(rIdx + 1 , n);
        if(nums[n] < target)
            return binarySearch(0, rIdx - 1);
        return -1;
    }
    
    int binarySearch(int start, int end){
        while(start <= end){
            int mid = (start) + (end - start) / 2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] > target){
                end = mid - 1;
            } else{
                start = mid + 1;
            }
        }
        return -1;
    }
    
    
    int findRotatedIndex(int start, int end){
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