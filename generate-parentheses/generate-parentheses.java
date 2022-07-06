class Solution {
    List<String> result = new ArrayList<>();
    int open = 0;
    int close = 0;
    public List<String> generateParenthesis(int n) {
        solve(n, new StringBuilder());
        return result;
    }
    
    boolean isValid(int n){
        return open == n && close == n;
    }
    
    void solve(int n, StringBuilder sb){
        if(isValid(n)){
            result.add(sb.toString());
            return;
        }
        
        if(open < n && close <= open){
            open++;
            sb.append("(");
            solve(n, sb);
            sb.deleteCharAt(sb.length() - 1);
            open--;
        }
        if(close < n){
            close++;
            sb.append(")");
            solve(n, sb);
            sb.deleteCharAt(sb.length() - 1);
            close--;
        }
    }
}