// https://leetcode.com/problems/find-median-from-data-stream/
// 用两个heap，然后一个加进来一个新数左右各过一遍。

class MedianFinder {
    PriorityQueue<Integer> minH;
    PriorityQueue<Integer> maxH;
    
    /** initialize your data structure here. */
    public MedianFinder() {
        minH = new PriorityQueue<Integer>();
        /* By default Java provides min heap. For max heap, we need to pass in a appropriate comparator */
        maxH = new PriorityQueue<Integer>(1, new Comparator<Integer>(){
            public int compare(Integer ob1, Integer ob2){
                return ob2.compareTo(ob1);
            }
        });        
    }
    
    public void addNum(int num) {
            maxH.add(num);
            minH.add(maxH.poll());            
            if(minH.size() > maxH.size()){
                maxH.add(minH.poll());
            }
    }
    
    public double findMedian() {        
        if(minH.size() == maxH.size()) 
            return (double) (maxH.peek() + minH.peek()) * 0.5 ;
        else
            return (double) maxH.peek();        
    }
}