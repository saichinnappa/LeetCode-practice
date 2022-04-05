class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int start = newInterval[0];
        int end = newInterval[1];
        int i = 0;
        int n = intervals.length;
        
        List<int[]> result = new ArrayList<>();
        
        while(i < n && intervals[i][1] < start){
            result.add(intervals[i]);
            i++;
        }
        
        
        while(i < n && intervals[i][0] <= end){
            start = Math.min(start, intervals[i][0]);
            end = Math.max(end, intervals[i][1]);
            i++;
        }
        
        result.add(new int[]{start, end});
        
        while(i < n){
            result.add(intervals[i]);
            i++;
        }
        
        return result.toArray(new int[0][0]);
    }
}