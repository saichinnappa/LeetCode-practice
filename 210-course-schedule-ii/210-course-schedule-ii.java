class Solution {
//     public int[] findOrder(int numCourses, int[][] prerequisites) {
//         int[] result = new int[numCourses];
//         //Course pre-req calculation (in degree of a vertex in graph)
//         int[] preReqCount = new int[numCourses];

//         for (int[] prerequisite : prerequisites) {
//             preReqCount[prerequisite[0]]++;
//         }

//         Queue<Integer> queue = new ArrayDeque<>();

//         for (int i=0; i<numCourses; i++) {
//             if ( preReqCount[i]== 0) {
//                 queue.offer(i);
//             }
//         }
        
//         // if(queue.isEmpty()) return new int[]{};

//         int index = 0;
//         while (!queue.isEmpty()) {
//             int course = queue.poll();
//             result[index] = course;
//             index++;
//             for(int[] pre : prerequisites){
//                 if(pre[1] == course){
//                     preReqCount[pre[0]]--;
//                     if(preReqCount[pre[0]] == 0){
//                         queue.offer(pre[0]);
//                     }
//                 }
//             }
            
//         }

//         return index == numCourses ? result : new int[0];
//     }
    
    public int[] findOrder(int numCourses, int[][] prerequisites) { 
    if (numCourses == 0) return null;
    // Convert graph presentation from edges to indegree of adjacent list.
    int indegree[] = new int[numCourses], order[] = new int[numCourses], index = 0;
    for (int i = 0; i < prerequisites.length; i++) // Indegree - how many prerequisites are needed.
        indegree[prerequisites[i][0]]++;    

    Queue<Integer> queue = new LinkedList<Integer>();
    for (int i = 0; i < numCourses; i++) 
        if (indegree[i] == 0) {
            // Add the course to the order because it has no prerequisites.
            order[index++] = i;
            queue.offer(i);
        }

    // How many courses don't need prerequisites. 
    while (!queue.isEmpty()) {
        int prerequisite = queue.poll(); // Already finished this prerequisite course.
        for (int i = 0; i < prerequisites.length; i++)  {
            if (prerequisites[i][1] == prerequisite) {
                indegree[prerequisites[i][0]]--; 
                if (indegree[prerequisites[i][0]] == 0) {
                    // If indegree is zero, then add the course to the order.
                    order[index++] = prerequisites[i][0];
                    queue.offer(prerequisites[i][0]);
                }
            } 
        }
    }

    return (index == numCourses) ? order : new int[0];
}
}