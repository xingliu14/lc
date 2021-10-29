// https://leetcode.com/problems/number-of-atoms/
// 想到这个算法本身不难，但是有些细节需要考虑：1.我们直接把Map存进去，然后每次用peek()来用；2.如果最外面有一个括号，那就最外面有一个没用的map；3.使用i来循环，同时不用自动更新，全部手动更新

class Solution {
    public String countOfAtoms(String formula) {
        int N = formula.length();
        ArrayDeque<Map<String, Integer>> stack = new ArrayDeque();
        stack.push(new TreeMap());

        for (int i = 0; i < N;) {
            if (formula.charAt(i) == '(') {
                stack.push(new TreeMap());
                i++;
            } else if (formula.charAt(i) == ')') {
                Map<String, Integer> top = stack.pop();
                int iStart = ++i, multiplicity = 1;
                while (i < N && Character.isDigit(formula.charAt(i))) i++;
                if (i > iStart) multiplicity = Integer.parseInt(formula.substring(iStart, i));
                for (String c: top.keySet()) {
                    int v = top.get(c);
                    stack.peek().put(c, stack.peek().getOrDefault(c, 0) + v * multiplicity);
                }
            } else {
                int iStart = i++;
                while (i < N && Character.isLowerCase(formula.charAt(i))) i++;
                String name = formula.substring(iStart, i);
                iStart = i;
                while (i < N && Character.isDigit(formula.charAt(i))) i++;
                int multiplicity = i > iStart ? Integer.parseInt(formula.substring(iStart, i)) : 1;
                stack.peek().put(name, stack.peek().getOrDefault(name, 0) + multiplicity);
            }
        }

        StringBuilder ans = new StringBuilder();
        for (String name: stack.peek().keySet()) {
            ans.append(name);
            int multiplicity = stack.peek().get(name);
            if (multiplicity > 1) ans.append("" + multiplicity);
        }
        return new String(ans);
    }
}