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
    
    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        List<List<Integer>> res=new  ArrayList<>();
        List<Integer> path=new ArrayList<>();
        
        path.add(0);
        dfs(graph,0,res,path);
        
        return res;
        
    }
    public static void dfs(int[][] graph, int node, List<List<Integer>> res, List<Integer> path){
        if(node==graph.length-1){
            res.add(new ArrayList<Integer>(path));
            return;
        }
        
        for(int nextNode: graph[node]){
            path.add(nextNode);
            dfs(graph,nextNode,res,path);
            path.remove(path.size()-1);
            
        }
        
    }
}