class Solution {
    List<String> result = new ArrayList();
    int n = 0;
    int open = 0, close = 0;
    public List<String> generateParenthesis(int n) {
        if(n == 1)
            return Arrays.asList("()");
        this.n = n;
        solve("");
        
        return result;
    }
    
    
    private boolean isValid(){
        return open == n && close == n;
    }
    
    
    private List<Character> getCandidates(){
        if(open == close && open < n){
            return Arrays.asList('(');
        } else if (open > close && open < n){
            return Arrays.asList('(', ')');
        } else if(open == n && close < n){
            return Arrays.asList(')');
        }
        return Arrays.asList('X');
    }
    
    
    private void solve(String s){
        if(isValid()){
            result.add(s);
            return;
        }
        
        for(char c : getCandidates()){
            s += c;
            if(c == '(')
                open++;
            else
                close++;
            solve(s);
            if(c == '(')
                open--;
            else 
                close--;
            s = s.substring(0, s.length() - 1);
        }
    }
    
}