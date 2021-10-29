// https://leetcode.com/problems/search-a-2d-matrix-ii/
// 我自己写的解答，每一行binary search，不过再加了个范围限制。复杂度一般

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int range = matrix[0].length - 1;
        for(int i = 0; i < matrix.length; i++) {
            range = binarySearch(matrix[i], range, target);
            if(matrix[i][range] == target) {
                return true;
            }
        }
        return false;
    }
    
    private int binarySearch(int[] array, int tail, int target) {
        int start = 0;
        while(start < tail) {
            int mid = start + (tail - start) / 2;
            if(array[mid] == target) {
                return mid;
            } else if(array[mid] < target) {
                start = mid + 1;
            } else {
                tail = mid;
            }
        }
        return tail;
    }
}