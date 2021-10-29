// https://leetcode.com/problems/employee-importance/
// 就是搜索

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<> ();
        for(Employee e : employees) {
            map.put(e.id, e);
        }
        
        ArrayDeque<Integer> stack = new ArrayDeque<> ();
        int result = 0;
        stack.push(id);
        
        while(!stack.isEmpty()) {
            int currId = stack.pop();
            result += map.get(currId).importance;
            for(int nextId : map.get(currId).subordinates) {
                stack.push(nextId);
            }
        }
        
        return result;
    }
}