class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        Deque<int[]> result = new LinkedList<int[]>();
        for(int i = 0; i < intervals.length; i++){
            if(i == 0){
                result.offer(intervals[i]);
            } else{
                int[] last = result.peekLast();
                if(last[1] >= intervals[i][0]){
                    result.pollLast();
                    result.add(new int[]{Math.min(last[0], intervals[i][0]), Math.max(last[1], intervals[i][1])});
                } else{
                    result.offer(intervals[i]);
                }
            }
        }
        return result.toArray(new int[0][0]);
    }
}