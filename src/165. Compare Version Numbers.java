// https://leetcode.com/problems/compare-version-numbers/
// 可能还稍微可以优化一下

class Solution {
    public int compareVersion(String version1, String version2) {
        int currVer1 = 0, currVer2 = 0, index1 = 0, index2 = 0;
        while(index1 < version1.length() || index2 < version2.length()) {
            char c1 = index1 < version1.length() ? version1.charAt(index1) : '.', c2 = index2 < version2.length() ? version2.charAt(index2) : '.';
            if(c1 == '.' && c2 == '.') {
                int comp = Integer.compare(currVer1, currVer2);
                if(comp != 0) {
                    return comp;
                } else {
                    currVer1 = 0;
                    currVer2 = 0;
                    index1++;
                    index2++;
                }
            }
            if(c1 != '.') {
                currVer1 = currVer1 * 10 + c1 - '0';
                index1++;
            }
            if(c2 != '.') {
                currVer2 = currVer2 * 10 + c2 - '0';
                index2++;
            }
        }
        return Integer.compare(currVer1, currVer2);
    }
}