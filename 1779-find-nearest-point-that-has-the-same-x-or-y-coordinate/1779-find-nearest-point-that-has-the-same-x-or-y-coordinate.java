class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        
        int dist = Integer.MAX_VALUE;
        int result = Integer.MAX_VALUE;
        int index = 0;
        for(int[] point : points){
            if(point[0] == x || point[1] == y){
                int newDist = Math.abs(point[0] - x) + Math.abs(point[1] - y);
                if( newDist <= dist ){
                    if(newDist == dist)
                        result = Math.min(result, index);
                    else{
                        dist = newDist;
                        result = index;
                    }
                        
                }
            }
            index++;
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}