class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] numsCopy = new int[m];
        System.arraycopy(nums1, 0, numsCopy, 0, m);
        
        int p1 = 0, p2 = 0, p = 0;
        
        while(p1 < m && p2 < n){
            if(numsCopy[p1] < nums2[p2]){
                nums1[p] = numsCopy[p1];
                p1++;
                p++;
            } else if (numsCopy[p1] > nums2[p2]){
                nums1[p] = nums2[p2];
                p2++;
                p++;
            } else{
                nums1[p] = nums2[p2];
                p++;
                nums1[p] = numsCopy[p1];
                p1++;
                p2++;
                p++;
            }
        }
        
        System.out.println(p1 +" "+ p2+" "+p);  
        if(p1 == m){
            System.arraycopy(nums2, p2, nums1, p, n - p2);
        } else if (p2 == n){
            System.arraycopy(numsCopy, p1, nums1, p, m - p1);
        }
    
    }
}