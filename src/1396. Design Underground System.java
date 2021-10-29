// https://leetcode.com/problems/design-underground-system/
// 就疯狂用map存

class UndergroundSystem {
    
    private Map<String, Double> timeMap;
    private Map<String, Integer> countMap;
    private Map<Integer, String> currCustomerMap;
    private Map<Integer, Integer> currTimeMap;

    public UndergroundSystem() {
        timeMap = new HashMap<> ();
        countMap = new HashMap<> ();
        currCustomerMap = new HashMap<> ();
        currTimeMap = new HashMap<> ();
        return;
    }
    
    public void checkIn(int id, String stationName, int t) {
        currCustomerMap.put(id, stationName);
        currTimeMap.put(id, t);
        return;
    }
    
    public void checkOut(int id, String endStation, int t) {
        String startStation = currCustomerMap.get(id);
        int spentTime = t - currTimeMap.get(id);
        currCustomerMap.remove(id);
        currTimeMap.remove(id);
        String key = startStation + "2" + endStation;
        int count = countMap.getOrDefault(key, 0);
        double currTime = timeMap.getOrDefault(key, (double) 0);
        timeMap.put(key, (count * currTime + spentTime) / (count + 1));
        countMap.put(key, count + 1);
        return;
    }
    
    public double getAverageTime(String startStation, String endStation) {
        return timeMap.getOrDefault(startStation + "2" + endStation, (double) 0);
    }
}