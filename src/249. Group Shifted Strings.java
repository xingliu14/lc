// https://leetcode.com/problems/group-shifted-strings/
// 标准化

class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> result = new ArrayList<> ();
        Map<String, List<String>> map = new HashMap<> ();
        for(String str : strings) {
            String numStr = getNumString(str);
            if(!map.containsKey(numStr)) {
                map.put(numStr, new ArrayList<String> ());
            }
            map.get(numStr).add(str);
        }
        for(List<String> list : map.values()) {
            result.add(list);
        }
        
        return result;
    }
    
    private String getNumString(String str) {
        StringBuilder sb = new StringBuilder();
        int offset = str.charAt(0) - 'a';
        for(char c : str.toCharArray()) {
            int curr = c - 'a' - offset;
            if(curr < 0) {
                curr += 26;
            }
            sb.append(curr + ",");
        }
        
        return sb.toString();
    }
}