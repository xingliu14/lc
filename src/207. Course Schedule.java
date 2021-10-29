// https://leetcode.com/problems/course-schedule/
// 复用Course Schedule的第二题的code

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Integer> blockNum = new HashMap<> ();
        Map<Integer, List<Integer>> blockCourses = new HashMap<> ();
        Set<Integer> availableCourses = new HashSet<> ();
        List<Integer> result = new ArrayList<> ();
        for(int[] pre : prerequisites) {
            blockNum.put(pre[0], blockNum.getOrDefault(pre[0], 0) + 1);
            List<Integer> list = blockCourses.getOrDefault(pre[1], new ArrayList<> ());
            list.add(pre[0]);
            blockCourses.put(pre[1], list);
        }
        for(int i = 0; i < numCourses; i++) {
            if(!blockNum.containsKey(i)) {
                availableCourses.add(i);
            }
        }
        while(!availableCourses.isEmpty()) {
            Set<Integer> nextAvailableCourses = new HashSet<> ();
            for(Integer course : availableCourses) {
                result.add(course);
                List<Integer> list = blockCourses.getOrDefault(course, new ArrayList<> ());
                for(Integer unblock : list) {
                    int num = blockNum.get(unblock);
                    if(num == 1) {
                        blockNum.remove(unblock);
                        nextAvailableCourses.add(unblock);
                    } else {
                        blockNum.put(unblock, num - 1);
                    }
                }
            }
            availableCourses = nextAvailableCourses;
        }
        
        if(result.size() == numCourses) {
            return true;
        } else {
            return false;
        }
    }
}