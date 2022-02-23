class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // List<List<String>> result = new ArrayList<>();
        // if(strs.length == 0)
        //     return result;
        Map<String, List<String>> map = new HashMap();
        for(String s : strs){
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String sorted = new String(arr);
            map.putIfAbsent(sorted, new ArrayList());
            map.get(sorted).add(s);
        }
    
        
        return new ArrayList(map.values());
    }
}