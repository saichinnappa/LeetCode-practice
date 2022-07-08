class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> queue = new PriorityQueue<Point>((p1, p2) -> Double.compare(p1.dist, p2.dist));
        for(int[] p : points){
            double dist = (Math.sqrt(Math.pow(p[0], 2) + Math.pow(p[1], 2)));
            queue.offer(new Point(p[0], p[1], dist));
        }
        
        int[][] result = new int[k][2];
        int i = 0;
        while(k != 0){
            Point p1 = queue.poll();
            
            result[i][0] = p1.x;
            result[i][1] = p1.y;
            i++;
            k--;
        }
        
        return result;
    }
}

class Point{
    int x;
    int y;
    double dist;
    Point(int x, int y, double dist){
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
    
}