class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        int[] course = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[] pre : prerequisites){
            map.putIfAbsent(pre[1], new ArrayList());
            map.get(pre[1]).add(pre[0]);
            course[pre[0]]++;
        }
        
        Deque<Integer> queue = new LinkedList<>();
        for(int i = 0; i < course.length; i++){
            if(course[i] == 0){
                queue.offer(i);
            }
        }
        
        while(!queue.isEmpty()){
            int first = queue.poll();
            List<Integer> cList = map.get(first);
            if(cList != null && cList.size() > 0){
                for(int c : cList){
                course[c]--;
                if(course[c] == 0){
                    queue.offer(c);
                }
             }    
            }
            
        }
        
        for(int c : course){
            if(c > 0)
                return false;
        }
        return true;
    }
}