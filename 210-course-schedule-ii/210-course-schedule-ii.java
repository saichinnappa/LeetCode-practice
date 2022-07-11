class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        int[] count = new int[numCourses];
        for(int[] pre : prerequisites){
            map.putIfAbsent(pre[1], new ArrayList<>());
            map.get(pre[1]).add(pre[0]);
            count[pre[0]]++;
        }
        
        Deque<Integer> queue = new LinkedList<>();
        
        for(int i = 0; i < count.length; i++){
            if(count[i] == 0){
                list.add(i);
                queue.offer(i);
            }
        }

        if(queue.isEmpty())
            return list.stream().mapToInt(Integer::intValue).toArray();
        
        while(!queue.isEmpty()){
            int first = queue.poll();
            if(map.containsKey(first)){
                List<Integer> l = map.get(first);
                for(int c : l){
                    count[c]--;
                    if(count[c] == 0){
                        list.add(c);
                        queue.offer(c);
                    }
                }
            }
        }
        return list.size() == numCourses ? list.stream().mapToInt(Integer::intValue).toArray() : new int[0];
    }
}