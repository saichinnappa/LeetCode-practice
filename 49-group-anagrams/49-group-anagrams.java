class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs){
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String s1 = new String(arr);
//             if(map.containsKey(s1))
                
//             else
                map.putIfAbsent(s1, new ArrayList());
                map.get(s1).add(s);
        }
        return new ArrayList(map.values());
    }
}