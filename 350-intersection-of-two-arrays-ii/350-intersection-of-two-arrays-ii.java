class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList();
        Set<Integer> set = new HashSet();
        for(int i = 0; i< nums1.length; i++){
            for(int j = 0; j < nums2.length; j++){
                if(nums1[i] == nums2[j] && !set.contains(j)){
                    list.add(nums2[j]);
                    set.add(j);
                    break;
                }
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
}