class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap();
        // Set<String> set = new HashSet();
        // List<List<String> result = new 
        
        for(int i = 0; i< strs.length; i++){
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            String s = new String(arr);
            if(map.containsKey(s)){
                List<String> list = new ArrayList(map.get(s));
                list.add(strs[i]);
                map.put(s, list);
            } else{
                // List<String> l = new ArrayList();
                // l.add(strs[i]);
                map.put(s, Arrays.asList(strs[i]));
            }
        }
        
        
        List<List<String>> result = new ArrayList();
        
        for(Map.Entry<String, List<String>> entry : map.entrySet()){
            result.add(entry.getValue());
        }
        
        return result;
    }
}