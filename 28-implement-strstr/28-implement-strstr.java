class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() > haystack.length()) return -1;
        if(needle.length() == 0) return 0;
        
        char[] harr = haystack.toCharArray();
        char[] narr = needle.toCharArray();

        for(int i = 0; i < harr.length; i++){
            if(harr[i] == narr[0] && (i + narr.length) <= harr.length){
                int count = 0;
                for(int j = 0; j < narr.length; j++){
                    if(harr[i+j] == narr[j]){
                        count++;
                    } else {
                        break;
                    }
                    if(count == narr.length){
                        return i;
                    }
                }
            }
        }
        return -1;
    }
}