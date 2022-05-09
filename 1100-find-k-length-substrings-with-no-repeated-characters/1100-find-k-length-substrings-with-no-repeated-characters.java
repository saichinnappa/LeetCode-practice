class Solution {
    public int numKLenSubstrNoRepeats(String s, int k) {
        int count = 0;
        Set<Character> set = new HashSet();
        int i = 0, j = 0;
        while (j < s.length()) {
            if (set.contains(s.charAt(j))) {
                set.remove(s.charAt(i++));
            } else {
                set.add(s.charAt(j++));
            }
            if (set.size() == k) {
                count += 1;
                set.remove(s.charAt(i++));
            }
        }
        return count;
    }
}