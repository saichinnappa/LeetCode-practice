class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals , (i1, i2) -> i1[0] - i2[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> a - b);
        for(int i = 0; i < intervals.length; i++){
            if(!pq.isEmpty() && pq.peek() <= intervals[i][0]){
                pq.poll();
            }
            pq.add(intervals[i][1]);
        }
        
        return pq.size();
    }
}