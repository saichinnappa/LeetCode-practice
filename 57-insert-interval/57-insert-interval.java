class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int start = newInterval[0];
        int end = newInterval[1];
        List<int[]> list = new ArrayList<>();
        int n = intervals.length;
        int index = 0;
        
        while(index < n && intervals[index][1] < start){
            list.add(intervals[index++]);
        }
        
        
        while(index < n && intervals[index][0] <= end){
            start = Math.min(start, intervals[index][0]);
            end = Math.max(end, intervals[index][1]);
            index++;
        }
        
        list.add(new int[]{start, end});
        
        while(index < n){
            list.add(intervals[index++]);
        }
        return list.toArray(new int[list.size()][]);
    }
}