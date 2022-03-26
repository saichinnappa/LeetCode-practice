class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        int dist = 1;
        queue.offer(beginWord);
        while(!queue.isEmpty()){
            int size = queue.size();
            int count = 1;
            while(size != 0){
                size--;
                String first = queue.poll();
                for(int i = 0; i < first.length(); i++){
                    String newString = first;
                    for(char c = 'a'; c <= 'z'; c++){
                       StringBuilder sb = new StringBuilder(newString);
                        sb.setCharAt(i, c);
                        if(set.contains(sb.toString())){
                             // System.out.println("FOUND-->"+ sb.toString());
                            if(sb.toString().equals(endWord)){
                               return dist + 1;
                            }
                            queue.offer(sb.toString());
                            set.remove(sb.toString());
                            
                        }
                    }
                }
            }
            dist++;
            
        }
        return 0;
    }
}