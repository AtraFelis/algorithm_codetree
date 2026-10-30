import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int n, m;
    private static List<List<Integer>> graph = new ArrayList<>();
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
        }

        visited = new boolean[n + 1];
        int ans = 0;

        while (true) {
            boolean flag = true;
            int root = 0;
            // 모든 노드에 방문했다면 flag = true 유지
            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    flag = false;
                    root = i;
                    break;
                }
            }
            if (flag)
                break;

            if (dfs(root))
                ans++;
        }

        System.out.println(ans);
    }

    private static boolean dfs(int root) {
        visited[root] = true;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { 0, root }); // {부모 노드, 자식 노드}

        while (!q.isEmpty()) {
            int parent = q.peek()[0];
            int curr = q.remove()[1];

            for (Integer child : graph.get(curr)) {

                // System.out.printf("%d %d %d\n", parent, curr, child);

                // 이웃이 부모 노드가 아닌데 방문처리 되어 있으면 싸이클
                if (child != parent && visited[child])
                    return false;

                if (child != parent) {
                    q.add(new int[] { curr, child });
                    visited[child] = true;
                }
            }

        }

        return true;
    }
}
