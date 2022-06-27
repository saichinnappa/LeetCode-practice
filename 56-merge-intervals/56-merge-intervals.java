class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        LinkedList<int[]> result = new LinkedList<int[]>();
        for(int i = 0; i < intervals.length; i++){
            if(i == 0){
                result.addLast(intervals[i]);
            } else{
                int[] last = result.getLast();
                if(last[1] >= intervals[i][0]){
                    result.removeLast();
                    result.addLast(new int[]{Math.min(last[0], intervals[i][0]), Math.max(last[1], intervals[i][1])});
                } else{
                    result.addLast(intervals[i]);
                }
            }
        }
        return result.toArray(new int[0][0]);
    }
}