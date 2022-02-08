// class Solution {
//     public boolean canFinish(int numCourses, int[][] prerequisites) {
//         // APPROACH 1: BFS
//         Queue<Integer> queue = new ArrayDeque();
//         int[] courseCounter = new int[numCourses];
//         Map<Integer, List<Integer>> graph = new HashMap();
        
//         // STEP 1: Build Adjacency list aka graph
//         for(int[] pre: prerequisites){
//             graph.putIfAbsent(pre[1], new ArrayList());
//             graph.get(pre[1]).add(pre[0]);
//             courseCounter[pre[0]]++; //using this counter to determine the courses which doesn't have a pre-req.
//         }
        
//          for(int i = 0; i < courseCounter.length; i++){
//             if(courseCounter[i] == 0){ // push all the courses which doesn't have a pre-req to the queue to begin processing.
//                 queue.offer(i);
//             }
//         }
//         boolean[] visited = new boolean[numCourses];
        
//         while(!queue.isEmpty()){
//             int first = queue.poll();
//             List<Integer> dependentCourses = graph.get(first);
            
//             visited[first] = true;
//             if(dependentCourses != null && dependentCourses.size() > 0){
//             for(int c : dependentCourses){
//                 if(visited[c] && courseCounter[c] == 0)
//                         return false;
//                     if(courseCounter[c] > 0){
//                         courseCounter[c]--;
//                     }
//                     if(courseCounter[c] == 0){
//                         queue.offer(c);
//                     }
//             }
//             }
//         }
            
//         for(int i = 0; i < courseCounter.length; i++){
//             if(courseCounter[i] > 0)
//                 return false;
                
//         }
        
        
//         return true;
//     }
// }


class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        HashMap<Integer, Boolean> seen = new HashMap<>();
        int[] indegree = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        
        // Building the graph
        for(int[] courses : prerequisites) {
            int to = courses[0];
            int from = courses[1];
            var list = map.getOrDefault(from, new ArrayList<>());
            list.add(to);
            map.put(from, list);
            indegree[to]++;
        }
        
        // Implementation of Kahn's Alg
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) q.add(i);
        }
        while(!q.isEmpty()) {
            int node = q.peek();
            q.poll();
            count++;
            if(map.containsKey(node)) {
                for(int nei : map.get(node)) {
                    indegree[nei]--;
                    if(indegree[nei] == 0) {
                        q.add(nei);
                    }
                }
            }
        }
        return count == numCourses;
    }
}