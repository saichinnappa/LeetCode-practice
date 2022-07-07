class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> s1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> s2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        s1.retainAll(s2);
        int[] result = new int[s1.size()];
        Integer[] array = s1.stream().toArray(Integer[]::new);
        return Arrays.stream(array).mapToInt(Integer::intValue).toArray();
    }
}