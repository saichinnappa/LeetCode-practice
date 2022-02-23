class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 1)
            return intervals;
        LinkedList<int[]> list = new LinkedList<>();
        
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);        
        
        for(int[] interval : intervals){
            if(list.size() == 0)
                list.add(interval);
            else{
                int[] lastElement = list.getLast();
                if(lastElement[1] >= interval[0]){
                    list.getLast()[1] = Math.max(list.getLast()[1], interval[1]);
                } else{
                    list.addLast(interval);
                }
            }
        }
        
        
    return list.toArray(new int[list.size()][]);
        
    }
}