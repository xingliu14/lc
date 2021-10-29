// https://leetcode.com/problems/4sum/
// 4 sum依然还能用循环加双指针，只不过要在很多地方跳过重复的数字

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<> ();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 3; i++) {
            for(int j = i + 1; j < nums.length - 2; j++) {
                int head = j + 1, tail = nums.length - 1;
                while(head < tail) {
                    if(nums[i] + nums[j] + nums[head] + nums[tail] == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[head], nums[tail]));
                        head++;
                        while(head < nums.length - 2 && nums[head] == nums[head - 1]) {
                            head++;
                        }
                        tail--;
                        while(tail > j + 2 && nums[tail] == nums[tail + 1]) {
                            tail--;
                        }
                    } else if(nums[i] + nums[j] + nums[head] + nums[tail] > target) {
                        tail--;
                        while(tail > j + 1 && nums[tail] == nums[tail + 1]) {
                            tail--;
                        }
                    } else {
                        head++;
                        while(head < nums.length - 1 && nums[head] == nums[head - 1]) {
                            head++;
                        }
                    }
                }
                while(j < nums.length - 3 && nums[j] == nums[j + 1]) {
                    j++;
                }
            }
            while(i < nums.length - 4 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return result;
    }
}