class Solution {
    public int compareVersion(String version1, String version2) {
        if((version1 == null || version1.length() == 0) && (version2 == null || version2.length() == 0))
            return 0;
        
        String[] v1arr = version1.split("\\.");
        String[] v2arr = version2.split("\\.");
        
        int maxLength = Math.max(v1arr.length, v2arr.length);
        int n1 = v1arr.length;
        int n2 = v2arr.length;
        
        int v1, v2;
        for(int i = 0; i < maxLength; i++){
            v1 = i < n1 ? Integer.parseInt(v1arr[i]) : 0;
            v2 = i < n2 ? Integer.parseInt(v2arr[i]) : 0;
            if(v1 > v2){
                return 1;
            } else if(v1 < v2){
                return -1;
            }
        }
        return 0;
        
        
    }
}