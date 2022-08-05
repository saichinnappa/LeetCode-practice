class Solution {
    int[] nums;
    public int findKthLargest(int[] nums, int k) {
        
        //APPROACH 1 : Using Heap
//         PriorityQueue<Integer> heap = new PriorityQueue<Integer>((a,b) -> b - a);
//         for(int i : nums)
//             heap.offer(i);
        
//         int ans = -1;
//         while(k != 0){
//             k--;
//             ans = heap.poll();
//         }
//         return ans;
        
        this.nums = nums;
        
        int size = nums.length;
        return quickSelect(nums, 0, size - 1, size - k);
    }
    
    
    int quickSelect(int[] nums, int left, int right, int k){
        if(left == right){
            return nums[left];
        }
        
        // Random random = new Random();
        // int pivot = left + random.nextInt(right - left);
        
       int pivot = parition( left, right);
        
        if(pivot == k)
            return nums[k];
        else if(pivot < k){
            return quickSelect(nums, pivot + 1, right, k);
        } 
        return quickSelect(nums, left, pivot - 1, k);
    }
    
    int parition(int start, int end){
         int partitionIndex = start - 1;
        int pivotElement = this.nums[end];
        for(int i = start; i <= end ; i++){
            if(this.nums[i] <= pivotElement){
                partitionIndex++;
                int temp = this.nums[partitionIndex];
                this.nums[partitionIndex] = this.nums[i];
                this.nums[i] = temp;
            }
        }
        return partitionIndex;
    }
    
      public void swap(int a, int b) {
    int tmp = this.nums[a];
    this.nums[a] = this.nums[b];
    this.nums[b] = tmp;
  }
    
}