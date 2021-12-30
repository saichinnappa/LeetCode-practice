class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] result = new int[length];
        int uLength = updates.length;
        int j = 0;
        while(uLength != 0){
            int[] u = updates[j];
            for(int i = u[0]; i <= u[1]; i++){
                result[i] += u[2];
            }
            j++;
            uLength--;
        }
        return result;
    }

}