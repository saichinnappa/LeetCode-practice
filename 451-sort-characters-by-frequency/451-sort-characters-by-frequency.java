class Solution {
    public String frequencySort(String s) {
        if(s.length() == 1)
            return s;
        Map<Character, Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();
        
        for(char c : arr){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        List<Character> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (a, b) -> map.get(b) - map.get(a));
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < list.size(); i++){
            char val = list.get(i);
            int count = map.get(val);
            while(count != 0){
                sb.append(val);
                count--;
            }
        }
        
        return sb.toString();
    }
}