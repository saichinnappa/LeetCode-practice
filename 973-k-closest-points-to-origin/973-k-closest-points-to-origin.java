class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        PriorityQueue<Point> queue = new PriorityQueue<Point>(new PointComparator());
        
        
        
        for(int[] p : points){
            double dist = Math.sqrt(Math.pow(0 - p[0], 2) + Math.pow(0 - p[1], 2));
            Point point = new Point(p[0], p[1], dist);
            if(queue.size() < k)
                queue.offer(point);
            else if(dist < queue.peek().dist){
                queue.poll();
                queue.offer(point);
            }
        }
        
        List<int[]> list = new ArrayList<int[]>();
        
        while(!queue.isEmpty()){
            Point p = queue.poll();
            list.add(new int[]{p.x, p.y});
        }
        
        return list.toArray(new int[0][0]);
        
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
    
    class PointComparator implements Comparator<Point> {
        @Override
        public int compare(Point p1, Point p2){
             if(p1.dist > p2.dist)
                 return -1;
            else if(p1.dist < p2.dist)
                return 1;
            else
                return 0;
        }
    }
}

