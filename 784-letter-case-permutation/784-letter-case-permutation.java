class Solution {
    List<String> result = new ArrayList<>();
    public List<String> letterCasePermutation(String s) {
        backtrack(s, 0, new StringBuilder());
        return result;
    }
    
    
    private void backtrack(String s, int i, StringBuilder sb){
        if(i == s.length()){
            result.add(sb.toString());
            return;
        }
        
        if(Character.isLetter(s.charAt(i))){
            sb.append(Character.toUpperCase(s.charAt(i)));
            backtrack(s, i + 1, new StringBuilder(sb));
            sb.deleteCharAt(sb.length() - 1);
            sb.append(Character.toLowerCase(s.charAt(i)));
            backtrack(s, i + 1, new StringBuilder(sb));
        } else{
            sb.append(s.charAt(i));
            backtrack(s, i + 1, new StringBuilder(sb));
        }
        
    }
    
}