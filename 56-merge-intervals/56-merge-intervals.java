class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (i, j) -> i[0] - j[0]);
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < intervals.length; i++){
            if(i == 0){
                list.add(intervals[i]);
            } else{
                int[] last = list.get(list.size() - 1);
                if(last[1] >= intervals[i][0]){
                    list.remove(list.size() - 1);
                    list.add(new int[]{last[0], Math.max(last[1], intervals[i][1])});
                } else{
                    list.add(intervals[i]);
                }
            }
            
        }
        return list.toArray(new int[0][0]);
    }
}