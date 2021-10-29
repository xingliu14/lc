// https://leetcode.com/problems/word-ladder-ii/
// 这道题巨绕，注意需要用map存到某一个string的所有path才快

class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList();
        Set<String> words = new HashSet(wordList);
        
        Set<String> curr = new HashSet();
        curr.add(beginWord);
        boolean found = false;
        
        // use hashMap to store all possible route ending at key
        Map<String, List<List<String>>> map = new HashMap();
        List<String> init = new ArrayList();
        init.add(beginWord);
        map.put(beginWord, new ArrayList());
        map.get(beginWord).add(init);
        
        
        while(!words.isEmpty() && !found && !curr.isEmpty()){
            // eliminate all previous layer words from dict
            words.removeAll(curr);
            // use another set to record next layers' words
            Set<String> next = new HashSet();
            
            // iterate through all curr
            for(String s: curr){
                char[] chs = s.toCharArray();
                List<List<String>> endPath  = map.get(s);
                for(int i = 0; i < chs.length; i++){
                    // randomly change a character
                    for(char ch = 'a'; ch <= 'z'; ch++){
                        if(chs[i] == ch) {
                            continue;
                        }
                        char tmp = chs[i];
                        chs[i] = ch;
                        String word = new String(chs);
                        //check if it is in the dict, if so next found, extending all routes
                        if(words.contains(word)){
                            next.add(word);
                            for(List<String> path : endPath){
                                List<String> nextPath = new ArrayList(path);
                                nextPath.add(word);
                                map.putIfAbsent(word, new ArrayList());
                                map.get(word).add(nextPath);
                                if(word.equals(endWord)){
                                    found = true;
                                    res.add(nextPath);
                                }
                            }

                        }
                        chs[i] = tmp;
                    }
                }
                map.remove(s);
            }
            // clear the previous layers words and update
            curr.clear();
            curr.addAll(next);
            
        }
        
        return res;
    }
    
}