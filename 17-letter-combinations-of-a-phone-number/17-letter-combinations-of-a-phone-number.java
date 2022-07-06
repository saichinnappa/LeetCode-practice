class Solution {
    List<String> result = new ArrayList<>();
    Map<Character, String> map = Map.of('2',"abc",
                                       '3', "def",
                                       '4', "ghi",
                                       '5', "jkl",
                                       '6', "mno",
                                       '7', "pqrs",
                                       '8', "tuv",
                                        '9', "wxyz");
    int digitsLength = 0;
    String digits;
    public List<String> letterCombinations(String digits) {
//         Map<String, String[]> map = new HashMap<>();
//         char[] arr = digits.toCharArray();
//         LinkedList<String> result = new LinkedList<String>();
//         if(arr.length == 0)
//             return result;
        
//         map.put("2", new String[]{"a", "b", "c"});
//         map.put("3", new String[]{"d", "e", "f"});
//         map.put("4", new String[]{"g", "h", "i"});
//         map.put("5", new String[]{"j", "k", "l"});
//         map.put("6", new String[]{"m", "n", "o"});
//         map.put("7", new String[]{"p", "q", "r", "s"});
//         map.put("8", new String[]{"t", "u", "v"});
//         map.put("9", new String[]{"w", "x", "y", "z"});
        
//         for(int i = 0; i < arr.length; i++){
//             String[] sarr = map.get(String.valueOf(arr[i]));
//             if(result.size() == 0){
//                 for(String s : sarr){
//                     result.add(s);
//                 }
//             } else{
//                 int idx = 0;
//                 int size = result.size();
//                 while(size != 0){
//                     for(String s: sarr){
//                         result.addLast(result.getFirst()+ s);
//                     }
//                     result.removeFirst();
//                     size--;
//                 }
//             }
//         }
        
//         return result;
        

        if(digits.length() == 0)
            return result;
        this.digits = digits;
        this.digitsLength = digits.length();
        backtrack(0, new StringBuilder());
        return result;
    }
    
    void backtrack(int index, StringBuilder path){
        if(path.length() == digitsLength){
            result.add(path.toString());
            return;
        }
        String s = map.get(digits.charAt(index));
        for(int i = 0; i < s.length(); i++){
            path.append(s.charAt(i));
            backtrack(index + 1, path);
            path.deleteCharAt(path.length() - 1);
        }
    }
}