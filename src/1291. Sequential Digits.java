// https://leetcode.com/problems/sequential-digits/
// 就只能靠他妈硬来

class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList<> ();
        int low_digit = String.valueOf(low).length(), high_digit = String.valueOf(high).length();
        for(int i = low_digit; i <= high_digit; i++) {
            for(int j = 1; i + j <= 10; j++) {
                int num = generateNum(j, i);
                if(num >= low && num <= high) {
                    result.add(num);
                }
            }
        }
        
        return result;
    }
    
    private int generateNum(int start, int digit) {
        int num = 0;
        for(int i = start; i < start + digit; i++) {
            num = 10 * num + i;
        }
        return num;
    }
}