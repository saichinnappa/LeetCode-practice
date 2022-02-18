class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean result = false;
        
        Queue<Integer> queue = new ArrayDeque();
        Map<Integer, List<Integer>> graph = new HashMap();
        int[] courses = new int[numCourses];
        for(int[] pre : prerequisites){
            graph.putIfAbsent(pre[1], new ArrayList());
            graph.get(pre[1]).add(pre[0]);
            courses[pre[0]]++;
        }
        
        for(int i = 0; i < courses.length; i++){
            if(courses[i] == 0)
                queue.add(i);
        }
        
        
        while(!queue.isEmpty()){
            int first = queue.poll();
            List<Integer> list = graph.get(first);
            if(list != null && list.size() > 0){
                for(int i : list){
                    courses[i]--;
                    if(courses[i] == 0)
                        queue.offer(i);
                }
            }
        }
        
        for(int c : courses){
            if(c > 0){
                return false;
            }
        }
        return true;
    }
}