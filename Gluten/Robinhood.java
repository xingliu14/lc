///////////////////// DESIGN //////////////////////////////
// 设计一个cron job scheduler, ~10k average jobs at any moment
// 如果job 没法在时限内做完 必须给通知

// 重点：
// 怎麽schedule cron task, 要2 tables, 需要有dispatch service, job queue, worker node, alerting service
// 如何通知用户，如果queue挂了怎么办， DB 选哪种

///////////////////// CODING //////////////////////////////
// house street match

List<String> findUnmatch(List<String> house, List<String> street) {
	Map<String, Integer> map = new HashMap<> ();
	List<String> result = new ArrayList<> ();

	for(String str : house) {
		map.put(str, map.getOrDefault(str, 0) + 1);
	}

	for(Strint str : street) {
		if(map.containsKey(str)) {
			if(map.get(str) == 1) {
				map.remove(str);
			} else {
				map.put(map.get(str) - 1);
			}
		} else {
			result.add(str);
		}
	}

	for(Map.Entry<String, Integer> entry : map.entrySet()) {
		for(int i = 0; i < entry.getValue(); i++) {
			result.add(entry.getKey());
		}
	}

	return Collections.sort(result);
}

// portfolio
<String, Integer> HashMap

// 第二问加一个TreeMap


// 股票最大利润


///////////////////// FOUNDATION //////////////////////////
