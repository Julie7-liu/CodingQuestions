// Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, such that:

//Only one letter can be changed at a time
//Each intermediate word must exist in the dictionary

public class Solution {
    /**
      * @param start, a string
      * @param end, a string
      * @param dict, a set of string
      * @return a list of lists of string
      */
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> rs = new ArrayList<List<String>>();

        if(dict == null || dict.size() == 0){
            return rs;
        }
        
        Map<String, Set<String>> map = new HashMap<String, Set<String>>();
        Map<String, Integer> dist = new HashMap<String, Integer>();
        bfs(start, end, dict, map, dist);

        List<String> path = new ArrayList<String>();
        Set<String> visited = new HashSet<String>();
        path.add(start);
        visited.add(start);
        dfs(rs, path, start, end, dict, visited, map, dist);
        return rs;
    }
    
    public void bfs(String start, String end, Set<String> dict, Map<String, Set<String>> map, Map<String, Integer> dist){
        int len = 1;
        Queue<String> queue = new LinkedList<String>();
        Set<String> visited = new HashSet<String>();
        queue.offer(start);
        while(queue.size() != 0){
            //get size of the current level
            int size = queue.size();
            //visit each word in this level
            for(int i = 0; i < size; i++){
                String word = queue.poll();
                if(visited.contains(word)){
                    continue;
                }
                
                if(!dist.containsKey(word)){
                    dist.put(word, len);
                }
                
                if(word.equals(end)){
                    return;
                }
                
                Set<String> nexts =  getNexts(word, dict);
                map.put(word, nexts);
                for(String next: nexts){
                    queue.offer(next);
                }
                
                visited.add(word);
            }//end for
            len ++;
        }//end while
    }
    
    public void dfs(List<List<String>> rs, List<String> path, String start, String end, Set<String> dict, Set<String> visited, Map<String, Set<String>> map, Map<String, Integer> dist){
        if(start.equals(end)){
            rs.add(new ArrayList(path));
            return;
        }
        
        Set<String> nexts;
        if(map.containsKey(start)){
            nexts = map.get(start);
        }else{
            // nexts = getNexts(start, dict); 
            return;
        }
         
        for(String next : nexts){
            if(visited.contains(next) || !dist.containsKey(next) || dist.get(start) + 1 != dist.get(next)){
                continue;
            }
            
            path.add(next);
            visited.add(next);
            dfs(rs, path, next, end, dict, visited, map, dist);
            path.remove(path.size() - 1);
            visited.remove(next);
        }
    }
    
    public Set<String> getNexts(String word, Set<String> dict){
        Set<String> nexts = new HashSet<String>();
        for(int i = 0; i < word.length(); i++){
            for(char c = 'a'; c <= 'z'; c++){
                if(word.charAt(i) == c){
                    continue;
                }
                
                String tmp = word.substring(0, i) + c + word.substring(i + 1, word.length());
                if(dict.contains(tmp)){
                    nexts.add(tmp);
                }
            }
        }
        return nexts;
    }
    
}

