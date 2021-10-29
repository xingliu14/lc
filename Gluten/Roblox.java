/////////////////////////////
// karat
/////////////////////////////

// yyds: https://www.jianshu.com/p/fdbcba5fe5bc

///////////////////////////////////// 1 parent-child pair /////////////////////////////////

class Solution {
	public List<Integer> q1(int[][] pairs) {
		Set<Integer> set = new HashSet<> ();
		// child - list of parents
		Map<Integer, Set<Integer>> map = new HashMap<> ();
		for(int[] pair : pairs) {
			set.add(pair[0]);
			set.add(pair[1]);
			List<Integer> parent = map.getOrDefault(pair[1], new HashSet<> ());
			parent.add(pair[0]);
			map.put(pair[1], parent);
		}

		List<Integer> result = new ArrayList<> ();
		for(Integer node : set) {
			if(!map.containsKey(node)) {
				result.add(node);
			}
		}
		return result;
	}

	public boolean q2(int node1, int node2) {
		Set<Integer> set1 = findAllParents(node1);
		Set<Integer> set2 = findAllParents(node2);
		for(int i : set1) {
			if(set2.contains(i)) {
				return true;
			}
		}
		return false;
	}

	private Set<Integer> findAllParents(Map<Integer, Set<Integer>> map, int node) {
		Set<Integer> result = new HashSet<> ();
		if(!map.containsKey(node)) {
			return result;
		}
		ArrayDeque<Integer> parents = new ArrayDeque<> ();
		parents.push(node);
		while(!parents.isEmpty()) {
			int parent = parents.pop();
			if(!map.containsKey(parent)) {
				continue;
			}
			Set<Integer> grandparents = map.get(parent);
			for(int gp : grandparents) {
				if(result.contains(gp)) {
					continue;
				}
				parents.push(gp);
				result.add(gp);
			}
		}
		return result;
	}

	private Integer findOldestAncester(Map<Integer, Set<Integer>> map, int node) {
		List<Integer> curr = new ArrayList<Integer> ();
		curr.add(node);
		Set<Integer> visited = new HashSet<> ();
		while(!curr.isEmpty()) {
			List<Integer> next = new ArrayList<> ();
			for(int i : curr) {
				if(!map.containsKey(i)) {
					continue;
				}
				Set<Integer> parents = map.get(i);
				for(int p : parents) {
					if(visited.contains(p)) {
						continue;
					}
					next.add(p);
					visited.add(p);
				}
			}
			if(next.isEmpty()) {
				return curr.get(0);
			}
			curr = next;
		}
		return node;
	}
}


/////////////////////////////////// 2 calculator ////////////////////////////
class Solution {
	public int q1(String exp) {
		if(exp == null || exp.length == 0) {
			return 0;
		}

		int result = 0, sign = 1, curr = 0;
		for(char c : exp.trim().toCharArray()) {
			if(Character.isDidit(c)) {
				curr = 10 * curr + c - '0';
			} else {
				result += sign * curr;
				curr = 0;
				if(c == '-') {
					sign = -1;
				} else {
					sign = 1;
				}
			}
		}
		result += sign * curr;
		return result;
	}

	public int q2(String exp) {
		if(exp == null || exp.length() == 0) {
			return 0;
		}

		int result = 0, sign = 1, curr = 0;
		ArrayDeque<Integer> stack = new ArrayDeque<> ();
		for(char c : exp.trim().toCharArray()) {
			if(Character.isDigit(c)) {
				curr = curr * 10 + c - '0';
			} else if(c == '+') {
				result += curr * sign;
				curr = 0;
				sign = 1;
			} else if(c == '-') {
				result += curr * sign;
				curr = 0;
				sign = -1;
			} else if(c == '(') {
				stack.push(result);
				stack.push(sign);
				result = 0;
				sign = 1;
			} else if(c == ')') {
				result += curr * sign;
				result *= stack.pop();
				result += stack.pop();
				curr = 0;
			}
		}
		return result;
	}
}

///////////////////////////////////// 3 rectangle //////////////////////////////////
class Solution {
	public List<Pair<Integer, Integer>> q1(int[][] mat) {
		List<Pair<Integer, Integer>> result = new ArrayList<>;
		if(mat == null || mat.length == 0 || mat[0].length == 0) {
			return result;
		}

		int m = mat.length, n = mat[0].length;
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(mat[i][j] == 1) {
					result.add(new Pair<Integer, Integer> (i, j));
					int height = 1, width = 1;
					while(i + height < m && mat[i + height][j] == 1) {
						height++;
					}
					while(j + width < n && mat[i][j + width] == 1) {
						width++;
					}
					result.add(new Pair<Integer, Integer> (i + height - 1, j + width - 1));
					return result;
				}
			}
		}

		return result;
	}

	public List<List<Pair<Integer, Integer>>> q2(int[][] mat) {
		List<List<Pair<Integer, Integer>>> result = new ArrayList<>;
		if(mat == null || mat.length == 0 || mat[0].length == 0) {
			return result;
		}

		int m = mat.length, n = mat[0].length;
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(mat[i][j] == 1) {
					List<Pair<Integer, Integer> curr = nre ArrayList<> ();
					curr.add(new Pair<Integer, Integer> (i, j));
					int height = 1, width = 1;
					while(i + height < m && mat[i + height][j] == 1) {
						height++;
					}
					while(j + width < n && mat[i][j + width] == 1) {
						width++;
					}

					for(int ii = i; i < i + height; i++) {
						for(int jj == j; jj < j + width; j++) {
							mat[ii][jj] = 0;
						}
					}

					curr.add(new Pair<Integer, Integer> (i + height - 1, j + width - 1));
					result.add(curr);
				}
			}
		}

		return result;
	}

	public List<List<Pair<Integer, Integer>>> q3(int[][] mat) {
		List<List<Pair<Integer, Integer>>> result = new ArrayList<> ();
		int m = mat.length, n = mat[0].length;
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(mat[i][j] == 1) {
					List<Pair<Integer, Integer>> curr = new ArrayList<> ();
					dfs(i, j, mat, curr);
					result.add(curr);
				}
			}
		}
		return result;
	}

	private void dfs(int x, int y, int[][] mat, List<Pair<Integer, Integer>> island) {
		if(x < 0 || x >= mat.length || y < 0 || y >= mat[0].length || mat[x][y] == 0) {
			return;
		}
		island.add(new Pair<Integer, Integer> (x, y));
		dfs(x + 1, y, mat, island);
		dfs(x - 1, y, mat, island);
		dfs(x, y + 1, mat, island);
		dfs(x, y - 1, mat, island);
	}
}

/////////////////////////////
// onsite
/////////////////////////////

//https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=763562