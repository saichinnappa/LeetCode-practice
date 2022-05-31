class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int result = Integer.MAX_VALUE;
        int dist = Integer.MAX_VALUE;
        for(int i = 0; i < points.length; i++){
            if(points[i][0] == x || points[i][1] == y){
                int dist1 = Math.abs(points[i][0] - x) + Math.abs(points[i][1] - y);
                if(dist > dist1){
                    result = i;
                    dist = dist1;
                }
            }
        }
        
      return result == Integer.MAX_VALUE ? -1 : result;  
    }
}