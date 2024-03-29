class Solution {
    public String alienOrder(String[] words) {
        Map<Character, List<Character>> adjList = new HashMap<>();
        Map<Character, Integer> countMap = new HashMap<>();
        for(String word : words){
            char[] arr = word.toCharArray();
            for(char c : arr){
                adjList.put(c, new ArrayList<>());
                countMap.put(c, 0);
            }
        }
        
        for(int i = 0; i < words.length - 1;  i++){
            String word1 = words[i];
            String word2 = words[i+ 1];
            if(word1.length() > word2.length() && word1.startsWith(word2))
                return "";
            for(int j = 0; j < Math.min(word1.length(), word2.length()); j++){
                if(word1.charAt(j) != word2.charAt(j)){
                    adjList.get(word1.charAt(j)).add(word2.charAt(j));
                    countMap.put(word2.charAt(j), countMap.get(word2.charAt(j)) + 1);
                    break;
                }
            }
        }
        
        
        StringBuilder sb = new StringBuilder();
        Deque<Character> queue = new LinkedList<>();
        for(Character c : countMap.keySet()){
            if(countMap.get(c) == 0)
                queue.offer(c);
        }
        
        while(!queue.isEmpty()){
            char first = queue.poll();
            sb.append(first);
            List<Character> list = adjList.get(first);
            for(char c : list){
                countMap.put(c, countMap.get(c) - 1);
                if(countMap.get(c) == 0)
                    queue.offer(c);
            }
        }
        
        if(sb.length() != countMap.size())
            return "";
        
        
        return sb.toString();
        
        
        
    }
}