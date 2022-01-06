// class Solution {
//     public int[] intersect(int[] nums1, int[] nums2) {
//         List<Integer> list = new ArrayList();
//         // Set<Integer> set = new HashSet();
//         // for(int i = 0; i< nums1.length; i++){
//         //     for(int j = 0; j < nums2.length; j++){
//         //         if(nums1[i] == nums2[j] && !set.contains(j)){
//         //             list.add(nums2[j]);
//         //             set.add(j);
//         //             break;
//         //         }
//         //     }
//         // }
//         // return list.stream().mapToInt(i -> i).toArray();
        
        
//         //Sorting
//         Arrays.sort(nums1);
//         Arrays.sort(nums2);
        
//         int n1 = nums1.length;
//         int n2 = nums2.length;
        
//         int i = 0, j =0;
        
//         while(i != n1 && j!=n2){
//             if(nums1[i] == nums2[j]){
//                 list.add(nums1[i]);
//                 i++;
//                 j++;
//             } else if (nums1[i] < nums2[j]){
//                 i++;
//             } else{
//                 j++;
//             }
//         }
        
//         return list.stream().mapToInt(k -> k).toArray();
//     }
// }
class Solution{
public int[] intersect(int[] nums1, int[] nums2) {
    if (nums1.length > nums2.length) {
        return intersect(nums2, nums1);
    }
    HashMap<Integer, Integer> m = new HashMap<>();
    for (int n : nums1) {
        m.put(n, m.getOrDefault(n, 0) + 1);
    }
    int k = 0;
    for (int n : nums2) {
        int cnt = m.getOrDefault(n, 0);
        if (cnt > 0) {
            nums1[k++] = n;
            m.put(n, cnt - 1);
        }
    }
    return Arrays.copyOfRange(nums1, 0, k);
}
}