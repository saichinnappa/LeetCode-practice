class Solution {
    public boolean isValid(String s) {
        if(s.length() == 1)
            return false;
        char[] arr = s.toCharArray();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        if(map.containsKey(arr[0])){
            return false;
        }
        Deque<Character> stack = new LinkedList<>();
        stack.push(arr[0]);
        for(int i = 1; i < arr.length; i++){
            
            if(map.containsKey(arr[i])){
                if(stack.isEmpty())
                    return false;
                char top = stack.pop();
                if(top != map.get(arr[i])){
                    return false;
                }
            } else{
                stack.push(arr[i]);
            }
            
        }
        
            return stack.isEmpty();
    
    }
}