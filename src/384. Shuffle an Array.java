// https://leetcode.com/problems/shuffle-an-array/
// 就很蠢，在同一个array操作，叫做Fisher-Yates Algorithm

class Solution {
    private int[] array;
    private int[] og;
    
    private Random rand = new Random();

    public Solution(int[] nums) {
        array = nums;
        og = nums.clone();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        array = og;
        og = array.clone();
        return array;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for(int i = array.length; i > 0; i--) {
            int index = rand.nextInt(i);
            int toMove = array[i - 1];
            array[i - 1] = array[index];
            array[index] = toMove;
        }
        return array;
    }
}