/////////////////////////////
// 电面
/////////////////////////////

// 1
// determine if a string contains '(' and ')' are vaild
boolean isValid(String str) {
	if(str == null || str.length() == 0) {
		return true;
	}

	int count = 0;
	for(char c : str.toCharArray()) {
		if(c == '(') {
			count++;
		}
		if(c == ')') {
			count--;
		}
		if(count < 0) {
			return false;
		}
	}
	return count == 0;
}

// 2
// BestRetainCache
public class BestRetainCache<K, V> {

	public static void main(String[] args) {

	}

	private Map<K, V> cache; 
	private TreeMap<Integer, Set<K>> rank; // Since it is ordered by Rank, an integer, TreeMap is super important
	private DataSource<K, V> dataSource; 
	private int capacity; 

	/* Constructor with a data source (assumed to be slow) and a cache size */ 
	public RetainBestCache(DataSource<K, V> ds, int capacity) {
		this.dataSource = ds;
		this.capacity = capacity;
		this.cache = new HashMap<K, V>();
		this.rank = new TreeMap<Integer, Set<K>>();
	}
	
	/* Gets some data. 
	 * If possible, retrieves it from cache to be fast. If the data is not cached, 
	 * retrieves it from the data source. If the cache is full, attempt to cache the returned data, 
	 * evicting the T with lowest rank among the ones that it has available 
	 * If there is a tie, the cache may choose any T with lowest rank to evict. 
	 * */ 
	public V get(K key) {
		V res = null;
		if (cache.containsKey(key)) {
			res = cache.get(key);
		} else {
			res = dataSource.get(key);
			int curRank = dataSource.getRank(key);
			// Add to cache
			cache.put(key, res);
			if (!rank.containsKey(curRank)) {
				rank.put(curRank, new HashSet<K>());
			}
			rank.get(curRank).add(key);
			
			if (cache.size() > capacity) {
				removeLowestRank();
			}
		}
		
		return res;
	}

	private void removeLowestRank() {
		Entry<Integer, Set<K>> firstEntry = rank.firstEntry();
		int firstKey = firstEntry.getKey();
		Set<K> firstSet = firstEntry.getValue();
		
		K toRemove = firstSet.iterator().next();
		
		// Remove from rank TreeMap
		firstSet.remove(toRemove);
		if (firstSet.isEmpty()) {
			rank.remove(firstKey);
		}
		
		// Remove from Cache Map
		cache.remove(toRemove);
	} 
}

class DataSource<K, V> {
	V get(K key) {
		return (V)new Object();
	}
	
	int getRank(K key) {
		return 1;
	}
}

///////////////////
//https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=764189
///////////////////

//////////////////////
// Onsite
//////////////////////

// 2 coding, 1 design, 1 deep dive, 1 host manager

// https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=764281&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26sortid%3D311

// https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=764505&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26sortid%3D311

// https://www.1point3acres.com/bbs/thread-767114-1-1.html




