// https://leetcode.com/problems/product-of-the-last-k-numbers/
// 存之前的结果

class ProductOfNumbers {
    
    ArrayList<Integer> A;

    public ProductOfNumbers() {
        A = new ArrayList();
        A.add(1);
    }

    public void add(int a) {
        if (a > 0)
            A.add(A.get(A.size() - 1) * a);
        else {
            A = new ArrayList();
            A.add(1);
        }
    }

    public int getProduct(int k) {
        int n = A.size();
        return k < n ? A.get(n - 1) / A.get(n - k - 1) : 0;
    }
}