import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] graph = new int[n + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[a][b] = w;
            graph[b][a] = w;
        }

        dist = new int[n + 1];
        dijkstra(n, graph);
        int originalDist = dist[n];

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                if (graph[i][j] == 0)
                    continue;

                int tmp = graph[i][j];
                graph[i][j] = 0;
                graph[j][i] = 0;

                dijkstra(n, graph);

                graph[i][j] = tmp;
                graph[j][i] = tmp;

                if (originalDist != dist[n])
                    ans++;
            }
        }

        System.out.println(ans);

    }

    // flag == true : path 기록
    private static void dijkstra(int n, int[][] graph) {
        boolean[] visited = new boolean[n + 1];
        int node = 1;

        dist = new int[n + 1];
        Arrays.fill(dist, (int) 1e9);
        dist[node] = 0;

        if (node == n)
            return;

        for (int i = 1; i < n; i++) {
            visited[node] = true;
            for (int next = 1; next <= n; next++) {
                if (graph[node][next] == 0)
                    continue;

                int newDist = dist[node] + graph[node][next];
                if (dist[next] > newDist) {
                    dist[next] = newDist;
                }
            }

            int minDist = (int) 1e9;
            for (int j = 1; j <= n; j++) {
                if (!visited[j] && minDist > dist[j]) {
                    node = j;
                    minDist = dist[j];
                }
            }
        }
    }
}
