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
        return quickSelect(points, k);
    }
    
    private int[][] quickSelect(int[][] points, int k) {
        int left = 0, right = points.length - 1;
        int pivotIndex = points.length;
        while (pivotIndex != k) {
            // Repeatedly partition the array
            // while narrowing in on the kth element
            pivotIndex = partition(points, left, right);
            if (pivotIndex < k) {
                left = pivotIndex;
            } else {
                right = pivotIndex - 1;
            }
        }
        
        // Return the first k elements of the partially sorted array
        return Arrays.copyOf(points, k);
    }

    private int partition(int[][] points, int left, int right) {
        int[] pivot = choosePivot(points, left, right);
        int pivotDist = squaredDistance(pivot);
        while (left < right) {
            // Iterate through the range and swap elements to make sure
            // that all points closer than the pivot are to the left
            if (squaredDistance(points[left]) >= pivotDist) {
                int[] temp = points[left];
                points[left] = points[right];
                points[right] = temp; 
                right--;
            } else {
                left++;
            }
        }
        
        // Ensure the left pointer is just past the end of
        // the left range then return it as the new pivotIndex
        if (squaredDistance(points[left]) < pivotDist)
            left++;
        return left;
    }

    private int[] choosePivot(int[][] points, int left, int right) {
        // Choose a pivot element of the array
        return points[left + (right - left) / 2];
    }
    
    private int squaredDistance(int[] point) {
        // Calculate and return the squared Euclidean distance
        return point[0] * point[0] + point[1] * point[1];
    }
}