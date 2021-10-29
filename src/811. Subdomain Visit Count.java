// https://leetcode.com/problems/subdomain-visit-count/
// MAP

class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<> ();
        for(String s : cpdomains) {
            String[] strs = s.split(" ");
            int count = Integer.valueOf(strs[0]);
            String domain = strs[1];
            while(domain != null) {
                map.put(domain, map.getOrDefault(domain, 0) + count);
                if(domain.indexOf(".") != -1) {
                    domain = domain.substring(domain.indexOf(".") + 1);
                } else {
                    domain = null;
                }
            }
        }
        List<String> result = new ArrayList<> ();
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            StringBuilder sb = new StringBuilder();
            sb.append(entry.getValue());
            sb.append(" ");
            sb.append(entry.getKey());
            result.add(sb.toString());
        }
        return result;
    }
}