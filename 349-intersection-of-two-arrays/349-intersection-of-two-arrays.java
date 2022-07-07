class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        Set<Integer> s1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> result = new HashSet<>();
        
        for(int n : nums2){
            if(s1.contains(n)){
                result.add(n);
            }
        }
        // Set<Integer> s2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        // s1.retainAll(s2);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}