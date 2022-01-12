class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 0)
            return -1;
        if (nums.length == 1)
            return nums[0] == target ? 0 : -1;
        int result = -1;
        int length = nums.length - 1;
        int rIdx = rotatedIndex(nums, 0, length);
        System.out.println(rIdx);
        if(rIdx == 0)
            return binarySearch(nums, target, 0, length);
        if(nums[rIdx] == target)
            return rIdx;
        else if(target > nums[length]){
            return binarySearch(nums, target, 0, rIdx - 1);
        } else{
            return binarySearch(nums, target, rIdx + 1, length);
        }
        
    }
    
    int binarySearch(int[] nums, int target, int start, int end){
        while(start <= end){
            int mid = (start + end)/2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] < target){
                start = mid + 1;
            } else{
                end = mid -1;
            }
        }
        return -1;
    }
    
    int rotatedIndex(int[] nums, int start, int end){
        
         if (nums[start] < nums[end])
            return 0;
        while(start <= end){
            
            int mid = (start + end) /2;
            System.out.println(start+" "+end+" "+mid);
            if(nums[mid] > nums[mid + 1])
                return mid + 1;
            else{
                if(nums[mid] < nums[start])
                    end = mid -  1;
                else
                    start = mid + 1;
            }
        }
        return 0;
    }
    
    
    
}