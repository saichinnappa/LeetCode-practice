class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] preCount = new int[numCourses];
        for(int [] pre : prerequisites){
            map.putIfAbsent(pre[1], new ArrayList<>());
            map.get(pre[1]).add(pre[0]);
            preCount[pre[0]]++;
        }
        
        Deque<Integer> queue = new LinkedList<>();
        
        int count = 0;
        for(int i = 0; i < preCount.length; i++){
            if(preCount[i] == 0){
                queue.offer(i);
                count++;
            }
        }
        
        while(!queue.isEmpty()){
            int first = queue.poll();
            List<Integer> courses = map.get(first);
            if(courses != null){
                for(int c : courses){
                    preCount[c]--;
                    if(preCount[c] == 0){
                        queue.offer(c);
                        count++;
                    }
                }
            }
        }
        
        return count == numCourses;
    }
}