// Since the Constaints are low we can Brute Force O(n^2) & check for every String 
// if every Other String is Similar
// (in context of this Problem if the 2 Anagrams only Differ by 1 Swap or at Most 2 different Characters throughtout the String).

// If Similar Perform a Union Operation by their Indexes & reduce the Component Size for every Successful Union Operation.

class Solution {
    public int numSimilarGroups(String[] strs) {
        int len = strs.length;
        UnionFind uf = new UnionFind(len);
        for(int i = 0; i < len ; i++)
        {
            for(int j = i + 1; j < len; j++)
                if(similar(strs[i], strs[j]))
                    uf.Union(i, j);
        }
        return uf.size;
    }
    
    private boolean similar(String a, String b)
    {
        int len = a.length();
        int difference = 0;
        for(int i = 0; i < len; i++)
        {
            if(a.charAt(i) != b.charAt(i))
            {
                if(difference == 2)
                    return false;
                difference++;
            }   
        }
        return true;
    }
    
    class UnionFind {
        int[] parent;
        int size;
        public UnionFind(int len){
            parent = new int[len];
            for(int i = 0; i < len; i++)
                parent[i] = i;
            
            size = len;
        }
        
        private int Find(int node)
        {
            if(parent[node] != node)
                parent[node] = Find(parent[node]);
            
            return parent[node];
        }
        
        private void Union(int a, int b)
        {
            int parentA = Find(a);
            int parentB = Find(b);
            if(parentA == parentB) return;
            parent[parentA] = parentB;
            size--;
        }
    }
}