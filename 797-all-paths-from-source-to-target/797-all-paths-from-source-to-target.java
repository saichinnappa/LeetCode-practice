class Solution {
    
    List<List<Integer>> result = new LinkedList();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        int source = 0;
        int dest = graph.length - 1;
        LinkedList<Integer> list = new LinkedList();
        list.add(source);
        dfs(graph, source, dest, list);
        
        return result;
    }
    
    void dfs(int[][] graph, int src, int dest, LinkedList<Integer> list){
        if(src == dest){
            result.add(new LinkedList<>(list));
            return;
        }
        int[] edges = graph[src];

        for(int edge : edges){
            list.add(edge);
            dfs(graph, edge, dest, list);
            list.removeLast();
        }
    }
}