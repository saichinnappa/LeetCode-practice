// class Solution {
//     public int[][] kClosest(int[][] points, int k) {
//         int[][] result = new int[k][k];
//         PriorityQueue<Point> queue = new PriorityQueue(new PointComparator<Point>());
//         Map<Double, Double> map = new HashMap();
//         for(int[] point : points){
//             double dist = Math.pow(point[0], 2) + Math.pow(point[1], 2);
//             Point p = new Point(point[0], point[1], dist);
            
//             if(queue.size() < k){
//                 queue.offer(p);
//             }
//             else if(p.dist < queue.peek().dist){
//                 queue.poll();
//                 queue.offer(p);
//             }
//         }
        
//         for(int i = 0; i < k; i++){
//             Point top = queue.poll();
//             result[i] = new int[]{top.x, top.y};
//         }
        
//         return result;
        
//     }
// }

// class Point{
//     int x;
//     int y;
//     double dist;
    
//     Point(int x, int y, double dist){
//         this.x = x;
//         this.y = y;
//         this.dist = dist;
//     }
// }

// public class PointComparator<T> implements Comparator<Point>{
//     @Override
//     public int compare(Point p0, Point p1){
//         if(p0.dist > p1.dist)
//             return -1;
//         else if(p0.dist < p1.dist)
//             return 1;
//         else
//             return 0;
//     }
// }

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Sort the array with a custom lambda comparator function
        Arrays.sort(points, (a, b) -> squaredDistance(a) - squaredDistance(b));
        
        // Return the first k elements of the sorted array
        return Arrays.copyOf(points, k);
    }
    
    private int squaredDistance(int[] point) {
        // Calculate and return the squared Euclidean distance
        return point[0] * point[0] + point[1] * point[1];
    }
};