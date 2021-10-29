// https://leetcode.com/problems/strong-password-checker/
// 这道题巨难。首先是需要分类，把<6、6~20、>20分别考虑，前两种比较容易，只需要考虑要补多少个/要换多少个。最后一个情况我们必须要减少，然后再考虑交换。因为减少和交换有可能有overlap。而且有优先级，最后再考虑交换和缺少的元素。

class Solution {
    public int strongPasswordChecker(String password) {
        boolean capitalFlag = false, lowerCaseFlag = false, numberFlag = false;
        for(int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if(Character.isDigit(ch)) {
                numberFlag = true;
            }
            else if (Character.isUpperCase(ch)) {
                capitalFlag = true;
            } else if (Character.isLowerCase(ch)) {
                lowerCaseFlag = true;
            }
            if(numberFlag && capitalFlag && lowerCaseFlag)
                break;
        }
        int missType = (numberFlag ? 0 : 1) + (capitalFlag ? 0 : 1) + (lowerCaseFlag ? 0 : 1);
        
        int replace = 0, zero = 0, one = 0;
        for(int i = 2; i < password.length(); i++) {
            if(password.charAt(i) == password.charAt(i - 1) && password.charAt(i) == password.charAt(i - 2)) {
                int length = 2;
                while(i < password.length() && password.charAt(i) == password.charAt(i - 1)) {
                    length++;
                    i++;
                }
                zero += length % 3 == 0 ? 1 : 0;
                one += length % 3 == 1 ? 1 : 0;
                replace += length / 3;
            }
        }
        
        if(password.length() < 6) {
            return Math.max(missType, 6 - password.length());
        } else if(password.length() <= 20) {
            return Math.max(missType, replace);
        } else {
            int delete = password.length() - 20;
            replace -= Math.min(zero, delete);
            delete = Math.max(delete - zero, 0);
            replace -= Math.min(delete, one * 2) / 2;
            delete = Math.max(delete - one * 2, 0);
            replace -= delete / 3;
            
            return password.length() - 20 + Math.max(missType, replace);
        }
    }
}