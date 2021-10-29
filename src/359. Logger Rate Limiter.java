// https://leetcode.com/problems/logger-rate-limiter/
// Map直接搞定

class Logger {
    
    public Map<String, Integer> map;

    /** Initialize your data structure here. */
    public Logger() {
        map = new HashMap<> ();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(!map.containsKey(message) || map.get(message) + 10 <= timestamp) {
            map.put(message, timestamp);
            return true;
        }
        return false;
    }
}