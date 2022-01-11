class Solution {
    public int findCircleNum(int[][] isConnected) {
        UnionByRank ubr = new UnionByRank(isConnected.length);
        for(int i = 0; i< isConnected.length; i++){
            for(int j = 0; j< isConnected[i].length; j++){
                if(i !=j && isConnected[i][j] == 1){
                    ubr.union(i, j);
                }
            }
        }
        
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
        System.out.println(Arrays.toString(root));
        Set<Integer> set = new HashSet();
        
        for(int r : root){
                set.add(r);
        }
        System.out.println(set);
        // return set.size();
        return count;
    }
    
    int find(int x){
        if(x == root[x])
            return x;
        return root[x] = find(root[x]);
        
        // while(x != root[x])
        //         x = root[x];
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
                    count--;
        }
        System.out.println(Arrays.toString(root));
    }
    
    boolean isConnected(int x, int y){
        return find(x) == find(y);
    }
}