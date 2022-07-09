class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(source < n && source == destination)
            return true;
        Map<Integer, ArrayList<Integer>> graph = new HashMap<>();
        for(int[] e : edges){
            graph.putIfAbsent(e[0], new ArrayList<>());
            graph.get(e[0]).add(e[1]);
            graph.putIfAbsent(e[1], new ArrayList<>());
            graph.get(e[1]).add(e[0]);
        }
        
        Deque<Integer> stack = new LinkedList<>();
        stack.push(source);
        boolean[] visited = new boolean[n];
        if(!graph.containsKey(source)){
            return false;
        }
        // 
        while(!stack.isEmpty()){
            int top = stack.pop();
            if(visited[top])
                continue;
            visited[top] = true;
            if(graph.containsKey(top)){
                List<Integer> elements = graph.get(top);
                for(int e  : elements){
                    if(e == destination)
                        return true;
                    if(!visited[e]){
                        stack.push(e);    
                    }
                    
                }    
            }
            
        }
        return false;
    }
}