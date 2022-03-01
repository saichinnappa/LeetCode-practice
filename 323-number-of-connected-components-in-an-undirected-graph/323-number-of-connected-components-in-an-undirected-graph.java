class Solution {
    public int countComponents(int n, int[][] isConnected) {
        UnionByRank ubr = new UnionByRank(n);
        // for(int i = 0; i< isConnected.length; i++){
        //     for(int j = 0; j< isConnected[i].length; j++){
        //             ubr.union(i, j);
        //         }
        //     }
        
        for(int[] edge : isConnected)
            ubr.union(edge[0], edge[1]);
        
        return ubr.getDistinctRootCount();
    }
}

class UnionByRank{
    int[] root;
    int[] rank;
    int count;
    
    UnionByRank(int size){
        this.root = new int[size];
        Arrays.setAll(this.root, i -> i);
        this.rank = new int[size];
        Arrays.fill(this.rank, 1);
        this.count = size;
    }
    
    int getDistinctRootCount(){
        return count;
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
                    count--;
        }
    }
    
    boolean isConnected(int x, int y){
        return find(x) == find(y);
    }
}