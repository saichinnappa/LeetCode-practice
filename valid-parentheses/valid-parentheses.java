class Solution {
    public boolean isValid(String s) {
        if(s.length() < 2)
            return false;
        Map<Character,Character> map = new HashMap();
        map.put('}', '{');
        map.put(')', '(');
        map.put(']', '[');
        
        char[] input = s.toCharArray();
        Deque<Character> stack = new ArrayDeque();
        
        for(int i = 0; i < input.length; i++){
            if(stack.isEmpty() && map.containsKey(input[i]))
                return false;
            if(!map.containsKey(input[i]))
                stack.push(input[i]);
            else if(!stack.isEmpty()){
                char top = stack.pop();
                if(top != map.get(input[i])){
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
}