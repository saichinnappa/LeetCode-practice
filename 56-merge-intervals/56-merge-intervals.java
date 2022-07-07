class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (i, j) -> i[0] - j[0]);
        LinkedList<int[]> list = new LinkedList<>();
        for(int i = 0; i < intervals.length; i++){
            if(i == 0){
                list.addFirst(intervals[i]);
            } else{
                int[] last = list.getLast();
                if(last[1] >= intervals[i][0]){
                    list.removeLast();
                    list.addLast(new int[]{Math.min(last[0], intervals[i][0]), Math.max(last[1], intervals[i][1])});
                } else{
                    list.addLast(intervals[i]);
                }
            }
            
        }
        return list.toArray(new int[0][0]);
    }
}