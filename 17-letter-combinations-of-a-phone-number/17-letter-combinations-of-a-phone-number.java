class Solution {
    public List<String> letterCombinations(String digits) {
        Map<String, String[]> map = new HashMap<>();
        char[] arr = digits.toCharArray();
        List<String> result = new ArrayList<String>();
        if(arr.length == 0)
            return result;
        
        map.put("2", new String[]{"a", "b", "c"});
        map.put("3", new String[]{"d", "e", "f"});
        map.put("4", new String[]{"g", "h", "i"});
        map.put("5", new String[]{"j", "k", "l"});
        map.put("6", new String[]{"m", "n", "o"});
        map.put("7", new String[]{"p", "q", "r", "s"});
        map.put("8", new String[]{"t", "u", "v"});
        map.put("9", new String[]{"w", "x", "y", "z"});
        
        for(int i = 0; i < arr.length; i++){
            String[] sarr = map.get(String.valueOf(arr[i]));
            if(result.size() == 0){
                for(String s : sarr){
                    result.add(s);
                }
            } else{
                int idx = 0;
                List<String> temp = new ArrayList<>(result);
                int size = temp.size();
                result = new ArrayList<String>();
                while(size != 0){
                    for(String s: sarr){
                        result.add(temp.get(idx) + s);
                    }
                    size--;
                    idx++;
                }
            }
        }
        
        return result;
    }
}