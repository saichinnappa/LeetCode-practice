class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> result = new LinkedList();
        for(int[] list : intervals){
            if(result.isEmpty() || result.getLast()[1] < list[0]){
                result.add(list);
            } else{
                result.getLast()[1] = Math.max(result.getLast()[1], list[1]);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}