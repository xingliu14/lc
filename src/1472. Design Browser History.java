// https://leetcode.com/problems/design-browser-history/
// 双向链表搞一波

class BrowserHistory {
    
    private class node {
        String url;
        node prev, next;
        node(String url) {
            this.url = url;
        }
    }
    
    node home, curr;

    public BrowserHistory(String homepage) {
        home = new node(homepage);
        home.prev = null;
        curr = home;
    }
    
    public void visit(String url) {
        curr.next = new node(url);
        curr.next.prev = curr;
        curr = curr.next;
    }
    
    public String back(int steps) {
        for(int i = 0; i < steps; i++) {
            if(curr.prev == null) {
                break;
            }
            curr = curr.prev;
        }
        return curr.url;
    }
    
    public String forward(int steps) {
        for(int i = 0; i < steps; i++) {
            if(curr.next == null) {
                break;
            }
            curr = curr.next;
        }
        return curr.url;
    }
}