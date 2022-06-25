class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] courses = new int[numCourses];
        
        for(int[] pre : prerequisites){
            courses[pre[0]]++;
            map.putIfAbsent(pre[1], new ArrayList<>());
            map.get(pre[1]).add(pre[0]);
        }
        
        Deque<Integer> queue = new LinkedList<>();
        for(int i =0; i < courses.length; i++){
            if(courses[i] == 0){
                queue.offer(i);
            }
        }
        
        if(queue.isEmpty())
            return false;
        
        while(!queue.isEmpty()){
            int first = queue.poll();
            if(map.containsKey(first)){
                List<Integer> list = map.get(first);
                for(int c : list){
                    courses[c]--;
                    if(courses[c] == 0)
                        queue.offer(c);
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