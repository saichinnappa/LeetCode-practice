class Solution {
    List<String> result = new ArrayList();
    public List<String> letterCombinations(String digits) {
        if(digits == "" || digits.length() == 0)
            return result;
        
        Map<Integer, List<String>> map = new HashMap();
        map.put(2, Arrays.asList("a", "b", "c"));
        map.put(3, Arrays.asList("d", "e", "f"));
        map.put(4, Arrays.asList("g", "h", "i"));
        map.put(5, Arrays.asList("j", "k", "l"));
        map.put(6, Arrays.asList("m", "n", "o"));
        map.put(7, Arrays.asList("p", "q", "r", "s"));
        map.put(8, Arrays.asList("t", "u", "v"));
        map.put(9, Arrays.asList("w", "x", "y", "z"));
        
        if(digits.length() == 1) return map.get(digits.charAt(0) - '0');
        solve(map.get(digits.charAt(0) - '0'), digits, 1, map);
        return result;
        
    }
    
    void solve(List<String> temp, String digits, int index, Map<Integer, List<String>> map){
        if(index == digits.length()) return;
        // temp = new ArrayList();
        List<String> l = new ArrayList<>(temp);
        List<String> list = map.get(digits.charAt(index) - '0');

        if(index == digits.length() - 1){
          for(String c : l){
                for(String c1 : list){
                    // c +=c1;
                    String v = c + c1;
                    if( v.length() == digits.length())
                    result.add(c+c1);
                }
            }
        } else if(index >= 1){
            for(String c : temp){
                for(String c1 : list){
                    // c +=c1;
                    // System.out.println(c+c1);
                    l.add(c+c1);
                    
                }
            }
        }
        
        index++;
        solve(l, digits, index, map);
    }
}