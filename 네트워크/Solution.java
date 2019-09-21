import java.util.*;

// 앞으론 이렇게 복잡하게 
class Solution {
	static ArrayList<Integer>[] adj;
	static boolean[] visited;

	public int solution(int n, int[][] computers) {
		adj = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++)
			adj[i] = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i != j)
					if (computers[i][j] == 1)
						adj[i + 1].add(j + 1);
			}
		}

		visited = new boolean[n + 1];
    
		int cnt = 0;
		while (!visitAll()) {
			int x;
			for (x = 1; x < visited.length; x++) {
				if (visited[x] == false)
					break;
			}
			DFS(x);
			cnt++;
		}
		return cnt;
	}

	public static boolean visitAll() {
		for (int i = 1; i < visited.length; i++)
			if (visited[i] == false)
				return false;
		return true;
	}

	public static void DFS(int x) {
		visited[x] = true;

		for (int y : adj[x]) {
			if (visited[y] == false) {
				DFS(y);
			}
		}
	}
}
