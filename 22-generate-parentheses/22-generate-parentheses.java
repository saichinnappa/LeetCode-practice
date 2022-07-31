class Solution {
    int open = 0;
    int close = 0;
    int n = 0;
    List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        this.n = n;
        solve(new StringBuilder());
        return result;
    }
    
    
    void solve(StringBuilder sb){
        if(open == n && close == n){
            result.add(sb.toString());
            return;
        }
        if(open < n){
            open++;
            sb.append("(");
            solve(sb);
            sb.deleteCharAt(sb.length() - 1);
            open--;
            
        }
        if (close < open){
            close++;
            sb.append(")");
            solve(sb);
            sb.deleteCharAt(sb.length() - 1);
            close--;
        }
    }
    
}