class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs){
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String sortedString = new String(arr);
            if(!map.containsKey(sortedString))
                map.put(sortedString, new ArrayList<String>());
            map.get(sortedString).add(s);
        }

        return new ArrayList<>(map.values());
    }
}