class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        int start = intervals[0][0];
        int end = intervals[0][1];
        int result = 0;
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] < end){
                end = Math.min(intervals[i][1], end);
                result++;
            } else{
                end = intervals[i][1];
            }
        }
        return result;
    }
}