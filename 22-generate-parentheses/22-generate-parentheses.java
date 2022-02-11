class Solution {
    List<String> result = new ArrayList();
    int n = 0;
    int open = 0, close = 0;
    public List<String> generateParenthesis(int n) {
        if(n == 1)
            return Arrays.asList("()");
        this.n = n;
        StringBuilder sb = new StringBuilder();
        solve(sb);
        
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
        } else{
            return Arrays.asList(')');
        }
    }
    
    
    private void solve(StringBuilder s){
        if(isValid()){
            result.add(s.toString());
            return;
        }
        
        for(char c : getCandidates()){
            s.append(c);
            if(c == '(')
                open++;
            else
                close++;
            solve(s);
            if(c == '(')
                open--;
            else 
                close--;
            s = s.deleteCharAt(s.length() - 1);
        }
    }
    
}