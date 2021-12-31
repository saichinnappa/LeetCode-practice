class Solution {
    public int[][] merge(int[][] intervals) {
     
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        
        LinkedList<int[]> list = new LinkedList();
        
        for(int[] interval : intervals){
            if(list.isEmpty() || list.getLast()[1] < interval[0]){
                list.addLast(interval);
            } else{
                int[] lElement = list.getLast();
                if(lElement[1] >= interval[0]){
                    list.removeLast();
                    int[] newVal  = new int[]{lElement[0], Math.max(lElement[1],interval[1])};
                    list.addLast(newVal);
                }
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}