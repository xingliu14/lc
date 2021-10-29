// https://leetcode.com/problems/dot-product-of-two-sparse-vectors/
// 只需要注意non primitive类型的比较！

class SparseVector {
    
    List<Pair<Long, Integer>> list;
    
    SparseVector(int[] nums) {
        list = new ArrayList<> ();
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                list.add(new Pair<Long, Integer> ((long) i, nums[i]));
            }
        }
        return;
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int i = 0, j = 0, result = 0;
        while(i < this.list.size() && j < vec.list.size()) {
            if(this.list.get(i).getKey().equals(vec.list.get(j).getKey())) {
                result += this.list.get(i).getValue() * vec.list.get(j).getValue();
                i++;
                j++;
            } else if(this.list.get(i).getKey() < vec.list.get(j).getKey()) {
                i++;
            } else {
                j++;
            }
        }
        return result;
    }
}