// 列车题
public static List<Integer> numberOfItems(String s, List<Integer> startIndices, List<Integer> endIndices) {
    int[] mem = new int[s.length()];
    int count = 0;
    for (int i = 0; i < s.length(); ++i) {
        if (s.charAt(i) == '|') {
            mem[i] = count;
        } else {
            ++count;
        }
    }
    List<Integer> ans = new ArrayList<>();
    for (int i = 0; i < startIndices.size(); ++i) {
        int start = startIndices.get(i) - 1;
        int end = endIndices.get(i) - 1;
        
        while (s.charAt(start) != '|') ++start;
        while (s.charAt(end) != '|') --end;

        ans.add(mem[end] - mem[start]);
    }
    return ans;
}

// number of province
public class Solution {
    public void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }
    public int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }
}

// 买衣服题
public int buy4Clothes(int[] hats, int[] shirts, int[] pants, int[] shoes, int target) {
    
}
