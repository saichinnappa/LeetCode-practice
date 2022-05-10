class Solution {
    public int[] asteroidCollision(int[] asteroids) {
                // int[] asteroids = {10,2,-5, -7};
        Stack<Integer> stack = new Stack<>();
        for(int asteroid: asteroids) {
            if(asteroid > 0) {
                stack.push(asteroid);
            } else {
                while(!stack.empty() && stack.peek() > 0 && stack.peek() < Math.abs(asteroid)) {
                    stack.pop();
                }
                if(stack.empty() || stack.peek() < 0) {
                    stack.push(asteroid);
                } else if(stack.peek() == Math.abs(asteroid)) {
                    stack.pop();
                }
            }
        }
        int[] answer = new int[stack.size()];
        for(int i=answer.length-1;i>=0;i--) {
            answer[i] = stack.pop();
        }
        return answer;
    }
}