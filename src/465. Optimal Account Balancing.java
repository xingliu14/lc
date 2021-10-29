// https://leetcode.com/problems/optimal-account-balancing/
// 当想找出一个完美的凑钱方案无望的时候，可能就只能搜索了，这里用backtrack

class Solution {
    public int minTransfers(int[][] transactions) {
        Map<Integer, Integer> map = new HashMap<> ();
        
        for(int[] tran : transactions) {
            int from = tran[0], to = tran[1], amount = tran[2];
            map.put(from, map.getOrDefault(from, 0) - amount);
            map.put(to, map.getOrDefault(to, 0) + amount);
        }
        
        int[] debt = new int[map.size()];
        int i = 0;
        for(int value : map.values()) {
            debt[i] = value;
            i++;
        }
        
        return getMinTrans(0, debt);
    }
    
    private int getMinTrans(int index, int[] debt) {
        while(index < debt.length && debt[index] == 0) {
            index++;
        }
        
        if(index == debt.length) {
            return 0;
        }
        
        int minTrans = Integer.MAX_VALUE;
        for(int i = index + 1; i < debt.length; i++) {
            if(debt[index] * debt[i] < 0) {
                debt[i] += debt[index];
                minTrans = Math.min(minTrans, getMinTrans(index + 1, debt) + 1);
                debt[i] -= debt[index];
            }
        }
        
        return minTrans;
    }
}