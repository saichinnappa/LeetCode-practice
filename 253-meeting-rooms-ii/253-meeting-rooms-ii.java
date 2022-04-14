class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);
        int end = intervals[0][1];
        int count = 1;
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> a - b);
        queue.offer(intervals[0][1]);
        for(int i = 1; i < intervals.length; i++){
            if(!queue.isEmpty() && queue.peek() <= intervals[i][0]){
                count++;
                
                queue.poll();
            } 
            // else{
                queue.offer(intervals[i][1]);
            // }
        }
         return queue.size();   
    }
}