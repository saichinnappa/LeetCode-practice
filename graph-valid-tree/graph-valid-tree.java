class Solution {
    public boolean validTree(int n, int[][] edges) {
        
        if(edges.length != n-1)
            return false;
        
        UnionByRank ubr = new UnionByRank(n);
        for(int[] edge : edges){
            if(ubr.isConnected(edge[0], edge[1]))
                return false;
            else
                ubr.union(edge[0], edge[1]);
        }
        return true;
    }
}

class UnionByRank{
    
    int[] root;
    int[] rank;
    int size;
    
    UnionByRank(int size){
        this.root = new int[size];
        Arrays.setAll(this.root, i -> i);
        this.rank = new int[size];
        Arrays.fill(this.rank, 1);
        this.size = size;
    }
    
    boolean isConnected(int x, int y){
        return find(x) == find(y);
    }
    
    int find(int x){
        if(x == root[x])
            return x;
        return root[x] = find(root[x]);
        
        // while(x != root[x]){
        //     x = root[x];
        // }
        // return x;
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
        }
    }
    
}