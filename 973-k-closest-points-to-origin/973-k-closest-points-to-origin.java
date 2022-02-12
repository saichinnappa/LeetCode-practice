class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] result = new int[k][k];
        PriorityQueue<Point> queue = new PriorityQueue(new PointComparator<Point>());
        Map<Double, Double> map = new HashMap();
        // double dist = 0.0;
        for(int[] point : points){
            double dist = Math.pow(point[0], 2) + Math.pow(point[1], 2);
            // if(map.containsKey(sum))
            //     dist = map.get(sum);
            // else{
            //     dist = sum;
            //     map.put(sum, dist);
            //     }
            Point p = new Point(point[0], point[1], dist);
            
            if(queue.size() < k){
                
                queue.offer(p);
            System.out.println("1 p.dist->"+p.dist+" -- "+queue.peek().dist);}
            else if(p.dist < queue.peek().dist){
                System.out.println("2 p.dist->"+p.dist+" -- "+queue.peek().dist);
                queue.poll();
                queue.offer(p);
            }
        }
        
        for(int i = 0; i < k; i++){
            Point top = queue.poll();
            result[i] = new int[]{top.x, top.y};
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

public class PointComparator<T> implements Comparator<Point>{
    @Override
    public int compare(Point p0, Point p1){
        if(p0.dist > p1.dist)
            return -1;
        else if(p0.dist < p1.dist)
            return 1;
        else
            return 0;
    }
}