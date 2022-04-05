class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        LinkedList<int[]> result = new LinkedList<>();
        // Deque<int[]> queue = new LinkedList<>();
        // queue.offer(intervals[0]);
        for(int[] i : intervals){
            if(result.size() == 0){
                result.addLast(i);
            } else{
                int[] last = result.getLast();
                if(last[1] >= i[0]){
                    result.removeLast();
                    result.addLast(new int[]{last[0], Math.max(last[1], i[1])});
                } else{
                    result.addLast(i);
                }
            }
        }
        return result.toArray(new int[0][0]);
    }
}