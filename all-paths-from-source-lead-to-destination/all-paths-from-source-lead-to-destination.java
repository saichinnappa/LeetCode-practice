class Solution {
 public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> graph = new HashMap();
        for (int[] edge : edges) {
            graph.putIfAbsent(edge[0], new ArrayList());
            graph.get(edge[0]).add(edge[1]);
        }
        return dfs(graph, source, destination, new HashSet());
    }
    
    boolean dfs(Map<Integer, List<Integer>> graph, int curPos, int destination, Set<Integer> visited) {
        if (!graph.containsKey(curPos)) {    // leaf node
            return curPos == destination;
        }
        
        for (int neighbor : graph.get(curPos)) {
            if (visited.contains(neighbor)) return false;  // That means there is a loop in the path
            visited.add(neighbor);
            if (!dfs(graph, neighbor, destination, visited)) {
                return false;
            }
            visited.remove(neighbor);
        }
        
        return true;
    }
}