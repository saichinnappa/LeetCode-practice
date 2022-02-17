class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        Queue<String> queue = new ArrayDeque();
        queue.offer(beginWord);
        int count = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size != 0){
                String first = queue.poll();
                char[] arr =  first.toCharArray();
                for(int i = 0; i < arr.length; i++){
                    char temp = arr[i];
                    for(char c = 'a'; c <= 'z'; c++){
                        arr[i] = c;
                        String next = new String(arr);
                        if(set.contains(next)){
                            if(next.equals(endWord))
                                return count+1;
                            queue.offer(next);
                            set.remove(next);
                        }
                    }
                    arr[i] = temp;
                }
                size--;
            }
            count++;
        }
        return 0;
    }
    
}