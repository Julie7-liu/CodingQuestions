//Given an array of strings, return all groups of strings that are anagrams.

public class Solution {
    /**
     * @param strs: A list of strings
     * @return: A list of strings
     */
    public List<String> anagrams(String[] strs) {
        if(strs == null || strs.length == 0){
            return null;
        }
        
        List<String> rs = new ArrayList<String>();
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for(String str : strs){
            int[] cnt = new int[26];
            for(int i = 0; i < str.length(); i++){
                cnt[str.charAt(i) - 'a'] ++;
            }
            String key = Arrays.toString(cnt);
            if(!map.containsKey(key)){
                ArrayList<String> list = new ArrayList<String>();
                list.add(str);
                map.put(key, list);
            }else{
                map.get(key).add(str);
            }
        }
        
        Set<String> keys = map.keySet();
        for(String key : keys){
            if(map.get(key).size() > 1){
                rs.addAll(map.get(key));
            }
        }
        
        return rs;
    }
}

