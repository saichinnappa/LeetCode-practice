class Solution {
    public int compareVersion(String version1, String version2) {
        if((version1 == null || version1.length() == 0) && (version2 == null || version2.length() == 0))
            return 0;
        
        String[] v1arr = version1.split("\\.");
        String[] v2arr = version2.split("\\.");
        
        int maxLength = (v1arr.length > v2arr.length) ? v1arr.length : v2arr.length;
        
        int[] v1 = new int[maxLength];
        int[] v2 = new int[maxLength];
        
        for(int i = 0; i < v1arr.length; i++){
            v1[i] = Integer.parseInt(v1arr[i]);
        }
        
        
        for(int i = 0; i < v2arr.length; i++){
            v2[i] = Integer.parseInt(v2arr[i]);
        }
        
        for(int i = 0; i < maxLength; i++){
            if(v1[i] > v2[i]){
                return 1;
            } else if(v1[i] < v2[i]){
                return -1;
            }
        }
        
        
        return 0;
        
        
    }
}