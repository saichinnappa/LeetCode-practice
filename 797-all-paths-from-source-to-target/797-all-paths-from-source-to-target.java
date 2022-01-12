// class Solution {
    
//     List<List<Integer>> result = new ArrayList();
//     public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
//                 if(graph == null || graph.length == 0) return null;
//         int source = 0;
//         int dest = graph.length - 1;
//         List<Integer> list = new ArrayList();
//         list.add(source);
//         dfs(graph, source, dest, list);
        
//         return result;
//     }
    
//     void dfs(int[][] graph, int src, int dest, List<Integer> list){
//         if(src == dest){
//             result.add(new ArrayList<>(list));
//             return;
//         }
//         int[] edges = graph[src];

//         for(int edge : edges){
//             list.add(edge);
//             dfs(graph, edge, dest, list);
//             list.remove(list.size() - 1);
//         }
//     }
// }

class Solution {
    List<List<Integer>> results = new ArrayList();
    int destination;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        if(graph == null || graph.length == 0) return null;
        destination = graph.length -1 ;
        traverse(0, destination, new ArrayList<>(), graph);
        return results;
        
    }
    
    public void traverse(int source, int target, List<Integer> path, int[][] graph){
        path.add(source);
        if(source == target){
            results.add(new ArrayList<>(path));
            return;
        }
        
        for(int i = 0; i< graph[source].length; i++){
           traverse(graph[source][i], target, path, graph);
            path.remove(path.size() - 1);
        }
        
    }
    
}