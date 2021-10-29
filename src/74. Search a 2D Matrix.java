// https://leetcode.com/problems/search-a-2d-matrix/
// 双重二分，特别注意的是两次二分第一次是找两个数中间，第二次是找一个数，条件略有不同

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = matrix.length, col = matrix[0].length;
        int head = 0, tail = row - 1, mid;
        
        while(head < tail - 1) {
            mid = head + (tail - head) / 2;
            if(matrix[mid][0] < target) {
                head = mid;
            } else if(matrix[mid][0] == target) {
                return true;
            } else {
                tail = mid;
            }
        }
        if(target < matrix[head][0] || target > matrix[tail][col - 1]) {
            return false;
        }
        
        int targetRow = head;
        if(tail == row - 1 && target >= matrix[tail][0]) {
            targetRow = tail;
        }
        head = 0;
        tail = col - 1;
        while(head < tail) {
            mid = head + (tail - head) / 2;
            if(matrix[targetRow][mid] == target) {
                return true;
            } else if(matrix[targetRow][mid] < target) {
                head = mid + 1;
            } else {
                tail = mid - 1;
            }
        }
        
        return matrix[targetRow][head] == target;
    }
}