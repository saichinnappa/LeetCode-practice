class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        Deque<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[s.length()];
        queue.add(0);
        while (!queue.isEmpty()) {
            int start = queue.poll();
            if (visited[start]) {
                continue;
            }
            visited[start] = true;
            for (int end = start + 1; end <= s.length(); end++) {
                if (wordDictSet.contains(s.substring(start, end))) {
                    queue.add(end);
                    if (end == s.length()) {
                        return true;
                    }
                }
            }
            
        }
        return false;
    }
}