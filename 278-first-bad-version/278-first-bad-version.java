/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int low = 0;
        int end = n;
        int badVersion = -1;
        while(low <= end){
            int mid = (low) + (end - low) / 2;
            if(isBadVersion(mid)){
                badVersion = mid;
                end = mid - 1;
            } else{
                low = mid + 1;
            }
        }
        
        return badVersion;
    }
}