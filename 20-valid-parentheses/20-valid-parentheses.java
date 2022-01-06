class Solution {
    public boolean isValid(String s) {
        if(s.length() == 0) return true;
        
        Map<Character, Character> map = new HashMap();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        
        char[] input = s.toCharArray();
        ArrayDeque<Character> stack = new ArrayDeque();
        
        for(int i = 0; i < input.length; i++){
            if(!map.containsKey(input[i]))
                stack.push(input[i]);
            else{
                if(stack.isEmpty()){
                    return false;
                } else{
                    char top = stack.pop();
                    if(top != map.get(input[i])){
                        return false;
                   }    
                }
                
            }
        }
        
        return stack.isEmpty();
        
    }
}