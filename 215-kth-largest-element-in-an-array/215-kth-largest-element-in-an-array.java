class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((a,b) -> b - a);
        for(int i : nums)
            heap.offer(i);
        
        int ans = -1;
        while(k != 0){
            k--;
            ans = heap.poll();
        }
        return ans;
    }
}