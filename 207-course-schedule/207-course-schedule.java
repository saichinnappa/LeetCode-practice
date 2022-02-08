class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        // TOPOLOGICAL SORT
        // Agorithm:
        /**
        STEP 1: Build the graph with relation pre-req -> courses
        ex: [0, 1], [2, 1]
        Graph:
        0 -> [1]
        1 -> []
        2 -> [1] **/
        
        Map<Integer, List<Integer>> graph = new HashMap();
        int[] counter = new int[numCourses];
        for(int[] pre : prerequisites){
            graph.putIfAbsent(pre[1], new ArrayList());
            graph.get(pre[1]).add(pre[0]);
            /**STEP 2:
            Keep track of the course counter to record a course as pre-req. For instance, in the above example 1 is not dependent on any courses, so its count would remain at 0.
            ex: [1, 0, 1] **/
            counter[pre[0]]++;
        }
        
        /** STEP 3:
            Push all the courses which have no dependency to queue.
        **/
        Queue<Integer> queue = new LinkedList();
        for(int i = 0; i < counter.length; i++){
            if(counter[i] == 0)
                queue.add(i);
        }
        
        /** STEP 4:
            While processing queue, decrement the current course requirement in counter with the help of the graph.
        **/
        boolean[] visited = new boolean[numCourses];
        while(!queue.isEmpty()){
            int first = queue.poll();
            visited[first] = true;
            List<Integer> courseList = graph.get(first);
            if(courseList != null && courseList.size() > 0){
                for(int c : courseList){
                    if(visited[c])
                        return false;
                    counter[c]--;
                    if(counter[c] == 0)
                        queue.offer(c);
                }
            }
        }
        
        // STEP 5:
        // Also, keep track of the visited courses, there might be a chance of a loop. So if the same course is being seen then just return before proceeding to other courses. Saves time!
        
        // STEP 6:
        // Finally, check the counter, if all the courses are processed rightly, then we expect the counter for all the courses to be zero.
        for(int c : counter){
            if(c > 0)
                return false;
        }
    
        
        return true;
        
    }
}