// https://leetcode.com/problems/fraction-to-recurring-decimal/solution/
// 主要是各种edge case很烦人

class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        boolean minus = (numerator < 0) ^ (denominator < 0 && numerator != 0);
        long nume = numerator, deno = denominator;
        nume = Math.abs(nume);
        deno = Math.abs(deno);
        long one = nume / deno;
        nume %= deno;
        List<Long> list = new ArrayList<> ();
        Map<Long, Integer> map = new HashMap<> ();
        boolean repeating = false;
        int repeatIndex = -1;
        while(nume != 0) {
            nume *= 10;
            if(map.containsKey(nume)) {
                repeating = true;
                repeatIndex = map.get(nume);
                break;
            }
            map.put(nume, list.size());
            list.add(nume / deno);
            nume %= deno;
        }
        StringBuilder sb = new StringBuilder();
        if(minus) {
            sb.append("-");
        }
        sb.append(one);
        if(list.size() != 0) {
            sb.append(".");
        }
        for(int i = 0; i < list.size(); i++) {
            if(i == repeatIndex) {
                sb.append("(");
            }
            sb.append(list.get(i));
        }
        if(repeating) {
            sb.append(")");
        }
        return sb.toString();
    }
}