class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<int[]>();
        int i = 0;
        int n = intervals.length;
        int start = newInterval[0];
        int end = newInterval[1];
        
        while(i < n && intervals[i][1] < start){
            list.add(intervals[i]);
            i++;
        }
        
        while(i < n && intervals[i][0] <= end){
            start = Math.min(intervals[i][0], start);
            end = Math.max(intervals[i][1], end);
            i++;
        }
        
        list.add(new int[]{start, end});
        
        while(i < n){
            list.add(intervals[i]);
            i++;
        }
        
        return list.toArray(new int[0][0]);
        
    }
}