class Solution {
    public int[][] merge(int[][] intervals) {
        LinkedList<int[]> list = new LinkedList<>();
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        for(int[] i : intervals){
            if(list.size() == 0){
                list.addLast(i);
            } else{
                int[] last = list.getLast();
                if(last[1] >= i[0]){
                    list.removeLast();
                    list.add(new int[]{last[0], Math.max(last[1], i[1])});
                } else
                    list.addLast(i);
            }
        }
       return list.toArray(new int[list.size()][]);
    }
}