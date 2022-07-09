class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int src = 0;
        int dest = graph.length - 1;
        List<Integer> list = new ArrayList<>();
        list.add(src);
        dfs(src, dest, graph, list);
        return result;
    }
    
    void dfs(int src, int dest, int[][] graph, List<Integer> list){
        if(src == dest){
            result.add(new ArrayList<>(list));
            return;
        }
        
        int[] g = graph[src];
        for(int n : g){
            list.add(n);
            dfs(n, dest, graph, list);
            list.remove(list.size() - 1);
        }
        
        
    }
}