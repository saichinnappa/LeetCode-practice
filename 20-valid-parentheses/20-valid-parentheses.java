class Solution {
    public boolean isValid(String s) {
        if(s.length() <= 1)
            return false;
        
        Map<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(')', '(');
        map.put(']', '[');
        
        char[] arr = s.toCharArray();
        Deque<Character> stack = new LinkedList<>();
        for(int i = 0; i < arr.length; i++){
            char curr = arr[i];
            if(!map.containsKey(curr)){
                stack.push(curr);
            } else{
                if(stack.isEmpty())
                    return false;
                else{
                    char top = stack.pop();
                    if(top != map.get(curr))
                        return false;
                }
            }
            
        }
        return stack.isEmpty();
    }
}