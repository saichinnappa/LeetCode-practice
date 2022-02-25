class Solution {
    public boolean isValid(String s) {
        if(s.length() < 2)
            return false;
        Map<Character, Character> map = new HashMap();
        map.put('}', '{');
        map.put(']', '[');
        map.put(')', '(');
        
        char[] input = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        
        
        for(int i = 0; i < input.length; i++){
            if(!map.containsKey(input[i])){
                stack.push(input[i]);
            }
            else{
                if(stack.isEmpty())
                    return false;
                    char top = stack.pop();
                    if(map.get(input[i]) != top){
                        return false;
                    } 
            }
        }
        
        return stack.size() == 0;
    }
}