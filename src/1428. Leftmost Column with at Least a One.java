// https://leetcode.com/problems/leftmost-column-with-at-least-a-one/
// 潇洒二分

class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dim = binaryMatrix.dimensions();
        int row = dim.get(0), col = dim.get(1), head = 0, tail = col - 1;
        Set<Integer> remain = new HashSet<> ();
        
        for(int i = 0; i < row; i++) {
            if(binaryMatrix.get(i, 0) == 1) {
                return 0;
            }
        }
        
        for(int i = 0; i < row; i++) {
            if(binaryMatrix.get(i, col - 1) == 1) {
                remain.add(i);
            }
        }
        if(remain.size() == 0) {
            return -1;
        }
        
        while(head < tail - 1) {
            int mid = head + (tail - head) / 2;
            Set<Integer> nextRemain = new HashSet<> ();
            for(int currNum : remain) {
                if(binaryMatrix.get(currNum, mid) == 1) {
                    nextRemain.add(currNum);
                }
            }
            if(nextRemain.size() == 0) {
                head = mid;
            } else {
                tail = mid;
                remain = nextRemain;
            }
        }
        
        return tail; 
    }
}