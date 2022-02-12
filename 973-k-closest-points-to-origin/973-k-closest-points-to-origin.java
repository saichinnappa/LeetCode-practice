// class Solution {
//     public int[][] kClosest(int[][] points, int k) {
//         int[][] result = new int[k][2];
//         PriorityQueue<Point> queue = new PriorityQueue(new PointComparator<Point>());
//         for(int[] point : points){
//             double dist = point[0] * point[0] + point[1] * point[1];
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

// // class Solution {
// //     public int[][] kClosest(int[][] points, int k) {
// //         // Use a lambda comparator to sort the PQ by farthest distance
// //         Queue<int[]> maxPQ = new PriorityQueue<>((a, b) -> b[0] - a[0]);
// //         for (int i = 0; i < points.length; i++) {
// //             int[] entry = {squaredDistance(points[i]), i};
// //             if (maxPQ.size() < k) {
// //                 // Fill the max PQ up to k points
// //                 maxPQ.add(entry);
// //             } else if (entry[0] < maxPQ.peek()[0]) {
// //                 // If the max PQ is full and a closer point is found,
// //                 // discard the farthest point and add this one
// //                 maxPQ.poll();
// //                 maxPQ.add(entry);
// //             }
// //         }
        
// //         // Return all points stored in the max PQ
// //         int[][] answer = new int[k][2];
// //         for (int i = 0; i < k; i++) {
// //             int entryIndex = maxPQ.poll()[1];
// //             answer[i] = points[entryIndex];
// //         }
// //         return answer;
// //     }
    
// //     private int squaredDistance(int[] point) {
// //         // Calculate and return the squared Euclidean distance
// //         return point[0] * point[0] + point[1] * point[1];
// //     }
// // };

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Precompute the Euclidean distance for each point,
        // define the initial binary search range,
        // and create a reference list of point indices
        double[] distances = new double[points.length];
        double low = 0, high = 0;
        List<Integer> remaining = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            distances[i] = euclideanDistance(points[i]);
            high = Math.max(high, distances[i]);
            remaining.add(i);
        }

        // Perform a binary search of the distances
        // to find the k closest points
        List<Integer> closest = new ArrayList<>();
        while (k > 0) {
            double mid = low + (high - low) / 2;
            List<List<Integer>> result = splitDistances(remaining, distances, mid);
            List<Integer> closer = result.get(0), farther = result.get(1);
            if (closer.size() > k) {
                // If more than k points are in the closer distances
                // then discard the farther points and continue
                remaining = closer;
                high = mid;
            } else {
                // Add the closer points to the answer array and keep
                // searching the farther distances for the remaining points
                k -= closer.size();
                closest.addAll(closer);
                remaining = farther;
                low = mid;
            }
        }
        
        // Return the k closest points using the reference indices
        k = closest.size();
        int[][] answer = new int[k][2];
        for (int i = 0; i < k; i++) {
            answer[i] = points[closest.get(i)];
        }
        return answer;
    };
    
    private List<List<Integer>> splitDistances(List<Integer> remaining, double[] distances,
                                               double mid) {
        // Split the distances around the midpoint
        // and return them in separate lists
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> closer = new ArrayList<>();
        List<Integer> farther = new ArrayList<>();
        result.add(closer);
        result.add(farther);
        for (int point : remaining) {
            if (distances[point] <= mid) {
                closer.add(point);
            } else {
                farther.add(point);
            }
        }
        return result;
    }
    
    private double euclideanDistance(int[] point) {
        // Calculate and return the squared Euclidean distance
        return point[0] * point[0] + point[1] * point[1];
    }
}