//Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:

//Only one letter can be changed at a time
//Each intermediate word must exist in the dictionary

public class Solution {
    /**
      * @param start, a string
      * @param end, a string
      * @param dict, a set of string
      * @return an integer
      */
    public int ladderLength(String start, String end, Set<String> dict) {
        if(dict == null || dict.size() == 0){
            return 0;
        }
        
        Queue<String> queue = new LinkedList<String>();
        Set<String> visited = new HashSet<String>();
        queue.offer(start);
        int len = 1;
        int size;
        String word;
        Set<String> nextWords;
        while(queue.size() != 0){
            size = queue.size();
            for(int i = 0; i < size; i++){
                word = queue.poll();
                
                //skip visited
                if(visited.contains(word)){
                    continue;
                }
                
                if(word.equals(end)){
                    return len;
                }
                
                nextWords = getNexts(word, dict);
                for(String next: nextWords){
                    queue.offer(next);
                }
                
                visited.add(word);
            }
            
            len ++;
        }
        
        return len;
    }
    
    public Set<String> getNexts(String word, Set<String> dict){
        Set<String> nexts = new HashSet<String>();
        
        if(dict == null || dict.size() == 0){
            return nexts;
        }
        
        String next;
        for(char c = 'a'; c <= 'z'; c ++){
            for(int i = 0; i < word.length(); i++){
                //skip if the same word
                if(c == word.charAt(i)){
                    continue;
                }
                
                next = word.substring(0, i) + c + word.substring(i + 1, word.length());
                if(dict.contains(next)){
                    nexts.add(next);
                }
            }
        }
        
        return nexts;
    }
}



