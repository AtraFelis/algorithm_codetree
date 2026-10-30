import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static class Edge {
        int to;
        int weight;

        public Edge(int to, int value) {
            this.to = to;
            this.weight = value;
        }
    }

    private static List<List<Edge>> graph = new ArrayList<>();
    private static boolean[] visited;
    private static int ans = 0;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Edge(b, w));
            graph.get(b).add(new Edge(a, w));
        }

        for (int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            visited[i] = true;
            dfs(i, 0);
        }

        System.out.println(ans);
    }

    private static void dfs(int node, int sum) {
        ans = Math.max(ans, sum);

        for (Edge edge : graph.get(node)) {
            int child = edge.to;
            int weight = edge.weight;

            if (visited[child])
                continue;

            visited[child] = true;
            dfs(child, sum + weight);
        }
    }
}
