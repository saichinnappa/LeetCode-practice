class Solution {
    public boolean isValid(String s) {
        if(s.length() <=1)
            return false;
        Map<Character, Character> map = new HashMap();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        
        Stack<Character> stack = new Stack();
        stack.push(s.charAt(0));
        
        for(int i = 1; i < s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                if(!stack.isEmpty() && map.get(c) == stack.peek()){
                    stack.pop();
                } else{
                    return false;
                }
            } else{
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}