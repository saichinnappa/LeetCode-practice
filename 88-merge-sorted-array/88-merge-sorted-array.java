class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = nums1.length - 1;
        int p2 = nums2.length - 1;
        int p1 = m - 1;
        
        // if(n == 0) return;
        // if(m == 0) {
        //     nums1[0] = nums2[0];
        //     return;
        // }
        
        while(p >=0){
            
            if(p2 < 0)
                break;
            
            if((p1>=0) && nums1[p1] > nums2[p2]){
                nums1[p] = nums1[p1];
                p--;
                p1--;
            } else{
                nums1[p] = nums2[p2];
                p2--;
                p--;
            }
        }
            
    }
}