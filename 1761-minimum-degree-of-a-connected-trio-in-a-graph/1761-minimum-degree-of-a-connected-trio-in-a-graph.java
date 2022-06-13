class Solution {
public int minTrioDegree(int n, int[][] edges) {
int[] degree = new int[n+1];

    int[][] adjMatrix = new int[n+1][n+1];
    
    for (int i=0; i<edges.length; i++) {
        adjMatrix[edges[i][0]][edges[i][1]] = 1;
        adjMatrix[edges[i][1]][edges[i][0]] = 1;
        
        degree[edges[i][0]]++;
        degree[edges[i][1]]++;
    }
    
    int ans = Integer.MAX_VALUE;
    for (int i=1; i<=n; i++) {
        for (int j=i+1; j<=n; j++) {
            if (adjMatrix[i][j] == 0) {
                continue;
            }
            
            for (int k = j+1; k<=n; k++) {
                if (adjMatrix[j][k] == 0 || adjMatrix[i][k] == 0) {
                    continue;
                }
                
                ans = Math.min(ans, degree[i] + degree[j] + degree[k] - 6);
            }
        }
    }
    
    if (ans == Integer.MAX_VALUE) {
        return -1;
    }
    
    return ans;
}
}