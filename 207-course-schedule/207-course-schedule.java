class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] courses = new int[numCourses];
        for(int[] pre : prerequisites){
            courses[pre[0]]++;
            map.putIfAbsent(pre[1], new ArrayList<>());
            map.get(pre[1]).add(pre[0]);
        }
        
        Deque<Integer> queue = new LinkedList<Integer>();
        
        for(int i = 0; i < courses.length; i++){
            if(courses[i] == 0){
                // System.out.println(i);
                queue.offer(i);
            }
        }
        
        if(queue.isEmpty())
            return false;
        
        // System.out.println(Arrays.toString(courses));
        
        while(!queue.isEmpty()){
            int first = queue.poll();
            // System.out.println(first);
            if(map.containsKey(first)){
                List<Integer> list = map.get(first);
                for(int i = 0; i < list.size(); i++){
                    courses[list.get(i)]--;
                    if(courses[list.get(i)] == 0)
                        queue.offer(list.get(i));
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