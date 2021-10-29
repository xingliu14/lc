// https://leetcode.com/problems/insert-delete-getrandom-o1/
// 这道题就是数据结构复杂度大赏。复习：HashSet和LinkedHashSet的查找和删除都是O(1)，但是不能直接访问，需要遍历。Map的添加、删除都是O(1)，但也不能直接访问，需要遍历。List的查找可以是O(1)，添加也是O(1)，但是删除中间的不是O(1)。所以我们把Map和List合起来，使得List每次删最后一个，达到O(1)。

class RandomizedSet {
    
    private Map<Integer, Integer> map;
    private List<Integer> list;
    Random rand = new Random();

    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<> ();
        list = new ArrayList<> ();
        return;
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.keySet().contains(val)) {
            return false;
        } else {
            map.put(val, list.size());
            list.add(val);    
        }
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.keySet().contains(val)) {
            return false;
        } else {
            int index = map.get(val);
            int change = list.get(list.size() - 1);
            list.set(index, change);
            map.put(change, index);
            list.remove(list.size() - 1);
            map.remove(val);
        }
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}