class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        
            if (nums.length == 1) {
      return nums[0];
    }
            if (nums[end] > nums[0]) {
      return nums[0];
    }
    
        while(start <= end){
      int mid = start + (end - start) / 2;
            if(nums[mid] > nums[mid + 1])
                return nums[mid+ 1];
                  if (nums[mid - 1] > nums[mid]) {
        return nums[mid];
      }
            else if (nums[mid] < nums[start])
                end = mid  - 1;
            else if (nums[mid] >= nums[start])
                start = mid + 1;
        }
        return -1;
    }
}