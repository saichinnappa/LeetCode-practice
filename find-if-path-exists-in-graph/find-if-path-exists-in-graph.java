class Solution {
    public boolean validPath(int n, int[][] edges, int start, int end) {
        if(edges.length == 0)
            return true;
        if(start == end)
            return false;
        
        ArrayDeque<Integer> stack = new ArrayDeque();        
        
        Map<Integer, List<Integer>> map = new HashMap();
        
        boolean[] visited = new boolean[n];
        
        for(int[] edge : edges){
            if(!map.containsKey(edge[0]))
                map.put(edge[0], new ArrayList());
            if(!map.containsKey(edge[1]))
                map.put(edge[1], new ArrayList());
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        
        stack.offer(start);
        while(!stack.isEmpty()){
            int top = stack.poll();
            visited[top] = true;
            List<Integer> list = map.get(top);
            if(list != null && list.size() > 0){
                for(int i : list){
                    if(i == end)
                        return true;
                    else if(!visited[i])
                        stack.offer(i);
                }
            }
        }
            
        return false;
    }
}