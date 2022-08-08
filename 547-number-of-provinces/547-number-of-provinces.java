class Solution {
    public int findCircleNum(int[][] isConnected) {
        UnionByRank ubr = new UnionByRank(isConnected.length);
        for(int i = 0; i < isConnected.length; i++){
            for(int j = 0; j < isConnected[i].length; j++){
                if(i !=j && isConnected[i][j] == 1){
                    ubr.union(i, j);
                }
            }
        }
        return ubr.getConnected();
    }
}

class UnionByRank{
    int[] rank;
    int[] root;
    int connected;
    
    UnionByRank(){
        
    }
    
    UnionByRank(int n){
        rank = new int[n];
        root = new int[n];
        Arrays.setAll(this.root, i -> i);
        Arrays.fill(rank, -1);
        connected = n;
    }
    
    int find(int x){
        if(x == root[x])
            return x;
        return root[x] = find(root[x]);
    }
    
    void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        if(rootX != rootY){
            if(rank[rootX] > rank[rootY]){
                root[rootY] = rootX;
            } else if(rank[rootY] > rank[rootX]){
                root[rootX] = rootY;
            } else{
                rank[rootX] += 1;
                root[rootY] = rootX;
            }
                    connected--;
        }
    }
    
    public int getConnected(){
        return connected;
    }
    
}