class Solution {
    class UnionFind{
        int root[];
        int rank[];
        
        UnionFind(int n){
            root=new int[n];
            rank=new int[n];
            Arrays.fill(root,-1);
            
            for(int i=0;i<n;i++){
                rank[i]=i;
            }
        }
        
        int find(int x){
            if(root[x]==-1){
                return x;
            }
            return root[x]=find(root[x]);
                
        }
        
        private void union(final int x, final int y){
            final int xRoot = find(x);
            final int yRoot = find(y);
            
            if (xRoot != yRoot){
                if (xRoot < yRoot){
                    root[yRoot] = xRoot;
                } else{
                    root[xRoot] = yRoot;
                }
            }
        }
    }
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        UnionFind dSet=new UnionFind(26);
        for(int i=0;i<s1.length();i++){
            
            int u=s1.charAt(i)-'a';
            int v=s2.charAt(i)-'a';
            
            dSet.union(u,v);
        }
        char charArr[]=new char[baseStr.length()];
        for(int i=0;i<baseStr.length();i++){
            int u=(int)baseStr.charAt(i)-'a';
            int v=dSet.find(u);
            v='a'+v;
            char ch=(char)v;
            charArr[i]=ch;
        }
        
        return new String(charArr);
    }
}


        