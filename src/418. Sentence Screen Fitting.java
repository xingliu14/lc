// https://leetcode.com/problems/sentence-screen-fitting/
// 直接怼的话可能会TLE，但是我直接加一步：大跃进，就起飞了

class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int count = 0, currIndex = 0, currRow = 0;
        
        while(currRow < rows) {
            int currCol = 0;
            while(cols - currCol >= sentence[currIndex].length()) {
                currCol += sentence[currIndex].length() + 1;
                if(currIndex == sentence.length - 1) {
                    count++;
                    currIndex = 0;
                } else {
                    currIndex++;
                }
            }
            if(currIndex == 0) {
                int rowStep = currRow + 1, countStep = count;
                while(currRow + rowStep < rows) {
                    currRow += rowStep;
                    count += countStep;
                }
            }
            currRow++;
        }
        
        return count;
    }
}