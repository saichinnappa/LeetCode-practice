class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList();
        // Set<Integer> set = new HashSet();
        // for(int i = 0; i< nums1.length; i++){
        //     for(int j = 0; j < nums2.length; j++){
        //         if(nums1[i] == nums2[j] && !set.contains(j)){
        //             list.add(nums2[j]);
        //             set.add(j);
        //             break;
        //         }
        //     }
        // }
        // return list.stream().mapToInt(i -> i).toArray();
        
        
        //Sorting
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int n1 = nums1.length;
        int n2 = nums2.length;
        
        int i = 0, j =0;
        
        while(i != n1 && j!=n2){
            if(nums1[i] == nums2[j]){
                list.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]){
                i++;
            } else{
                j++;
            }
        }
        
        return list.stream().mapToInt(k -> k).toArray();
    }
}