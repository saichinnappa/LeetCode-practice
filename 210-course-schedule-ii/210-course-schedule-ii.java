class Solution {
    public int[] findOrder(int numCourses, int[][] arr) {
        
        Map<Integer, List<Integer>> m = new HashMap<>();
        for( int i = 0; i < arr.length; i++ ) {
            m.putIfAbsent(arr[i][0], new LinkedList<Integer>());
            for( int j = 1; j < arr[i].length; j++ ) {
                m.get(arr[i][0]).add(arr[i][j]);
            }
        }
        
        boolean[] visited = new boolean[numCourses];
        Set<Integer> result = new LinkedHashSet<>();
        
        for( int course = 0; course < numCourses; course++ ) {
            if( !getDependentCourse(course, m, visited, result) ) {
                result.clear();
                break;
            }
        }
        
        //System.out.println(m);
        //System.out.println(result);
        
        return result.stream().mapToInt(i->i).toArray();
        
    }
    
    boolean getDependentCourse(int course, Map<Integer, List<Integer>> m, boolean[] visited, Set<Integer> result) {
    
        if( result.contains(course) ) {
            return true;
        }
        
        if( ! m.containsKey(course) ) {
            result.add(course);
            return true;
        }
        
        if ( visited[course] ) {
            //cycle found in connection
            return false;
        }
        
        visited[course] = true;
        
        
        for( int dc: m.get(course) ) {
            if( !getDependentCourse(dc, m, visited, result) ) {
                return false;
            }
        }
        
        visited[course] = false;
        result.add(course);
        return true;
    }
    
}