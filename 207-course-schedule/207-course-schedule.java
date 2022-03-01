class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] courses = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[] pre : prerequisites){
            map.putIfAbsent(pre[1], new ArrayList());
            map.get(pre[1]).add(pre[0]);
            courses[pre[0]]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();;
        
        for(int i = 0; i < courses.length; i++){
            if(courses[i] == 0){
                queue.offer(i);
            }
        }
        
        while(!queue.isEmpty()){
            int first = queue.poll();
            List<Integer> preReqs = map.get(first);
            if(preReqs != null){
                for(int i : preReqs){
                    courses[i]--;
                    if(courses[i] == 0){
                        queue.offer(i);
                    }
                }
            }
            
        }
        
        for(int c : courses){
            if(c > 0)
                return false;
        }
        return true;
    }
}