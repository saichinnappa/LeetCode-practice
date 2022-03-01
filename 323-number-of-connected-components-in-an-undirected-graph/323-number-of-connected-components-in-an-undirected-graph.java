class Solution {
    public int countComponents(int n, int[][] edges) {
        UnionByRank ubr = new UnionByRank(n);
        for(int[] e: edges){
            ubr.union(e[0],e[1]);
        }
        
        return ubr.getCount();
    }
}

class UnionByRank{
    int[] rank;
    int[] root;
    int size;
    
    UnionByRank(int n){
        this.size = n;
        this.rank = new int[n];
        this.root = new int[n];
        Arrays.setAll(this.rank, i -> 1);
        Arrays.setAll(this.root, i -> i);
    }
    
    boolean isConnected(int x, int y){
        return find(x) == find(y);
    }
    
    int find(int x){
        while(x != root[x]){
            x = root[x];
        }
        return x;
    }
    
    void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        if(rootX != rootY){
            if(rank[rootX] > rank[rootY]){
                root[rootY] = rootX;
            } else if(rank[rootX] < rank[rootY]){
                root[rootX] = rootY;
            } else{
                root[rootY] = rootX;
                rank[rootX] += 1;
            }
            
            size--;
        }
    }
    
    int getCount(){
        return size;
    }
    
    
}