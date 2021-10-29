// https://leetcode.com/problems/word-break-ii/
// 同样是dfs/backtrack，但还是需要用一个map存所有已经跑过的string

class Solution {
    private Map<String, List<String>> map = new HashMap<> ();
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        map.put("", new ArrayList<> (Arrays.asList("")));
        return dfs(s, wordDict);
    }
    
    private List<String> dfs(String s, List<String> dict) {
        if(map.containsKey(s)) {
            return map.get(s);
        }
        List<String> result = new ArrayList<> ();
        for(String str : dict) {
            if(s.startsWith(str)) {
                List<String> subList = dfs(s.substring(str.length()), dict);
                for(String subString : subList) {
                    result.add(str + (subString == "" ? "" : " ") + subString);
                }
            }
        }
        map.put(s, result);
        return result;
    }
}