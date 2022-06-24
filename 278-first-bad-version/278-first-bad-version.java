/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    
    public int firstBadVersion(int n) {
        int start = 1;
        int firstBadVersion = 0;
        while(start <= n){
           int mid = start + ((n - start) /2);
            if(isBadVersion(mid)){
 
                n = mid - 1;
                firstBadVersion = mid;
            }
            else
                start = mid + 1;
        }
        return start;
    }
}