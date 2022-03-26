class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int count = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size != 0){
                size--;
                String first = queue.poll();
                char[] arr = first.toCharArray();
                for(int i = 0; i < arr.length; i++){
                    char temp = arr[i];
                    for(char c = 'a'; c <= 'z'; c++){
                        arr[i] = c;
                        String formedString = new String(arr);
                        if(wordSet.contains(formedString)){
                            if(formedString.equals(endWord)){
                                return count + 1;
                            }
                            wordSet.remove(formedString);
                            queue.offer(formedString);
                        }
                    }
                    arr[i] = temp;
                }
            }
            count++;
        }
            
        return 0;
    }
}