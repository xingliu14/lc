// https://leetcode.com/problems/read-n-characters-given-read4/
// 理解题意即可

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        int count = 0;
        for(int i = 0; i <= n / 4; i++) {
            char[] buf4 = new char[4];
            int currCount = Math.min(read4(buf4), n - i * 4);
            for(int j = 0; j < currCount; j++) {
                buf[i * 4 + j] = buf4[j];
            }
            count += currCount;
            if(currCount != 4) {
                break;
            }
        }
        return count;
    }
}