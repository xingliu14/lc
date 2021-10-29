// https://leetcode.com/problems/the-number-of-full-rounds-you-have-played/
// 数学处理

class Solution {
    public int numberOfRounds(String startTime, String finishTime) {
        String[] start = startTime.split(":"), finish = finishTime.split(":");
        int sH = Integer.parseInt(start[0]), sM = Integer.parseInt(start[1]), fH = Integer.parseInt(finish[0]), fM = Integer.parseInt(finish[1]);
        
        int startIndex = 4 * sH + (sM + 14) / 15, finishIndex = 4 * fH + fM / 15;
        if(startTime.compareTo(finishTime) > 0) {
            return 96 - startIndex + finishIndex;
        }
        
        return finishIndex - startIndex;
    }
}