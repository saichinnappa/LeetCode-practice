class Solution {
    public String reverseWords(String s) {
        String[] sArr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = sArr.length - 1; i > -1; i--){
            if(sArr[i].trim().length() > 0){
                sb.append(sArr[i].trim());
                sb.append(" ");
            }
        }
        
        return sb.toString().trim();
    }
}