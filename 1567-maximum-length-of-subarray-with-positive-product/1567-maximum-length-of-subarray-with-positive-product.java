class Solution {
    public int getMaxLen(int[] input) {
               int startIdx = 0;
        int firstNegIdx = 0;
        boolean isFirst = false;
        int negCount = 0;
        int result = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i] < 0) {
                negCount++;
                if (!isFirst) {
                    firstNegIdx = i;
                    isFirst = true;
                }
            } else if (input[i] == 0) {
                startIdx = i + 1;
                firstNegIdx = 0;
                negCount = 0;
                isFirst = false;
            }
            int x = 0;
            if (negCount % 2 == 0)
                x = i - startIdx + 1;
            else
                x = i - firstNegIdx;
            System.out.println("X: " + x + " I: " + i + " FN: " + firstNegIdx);
            result = Math.max(result, x);
        }
        return result;
    }
}