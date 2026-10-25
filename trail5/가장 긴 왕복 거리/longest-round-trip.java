import java.io.*;
import java.util.*;

public class Main {
    public static class Edge {
        int to, weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    private static List<List<Edge>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(u).add(new Edge(v, w));
        }

        int[][] dist = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            dist[i] = dijkstra(i);
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (i == x)
                continue;
            ans = Math.max(ans, dist[i][x] + dist[x][i]);
        }
        
        System.out.println(ans);
    }

    private static int[] dijkstra(int start) {

        int[] dist = new int[graph.size()];
        for (int i = 0; i < dist.length; i++) {
            dist[i] = (int) 1e8;
        }
        dist[start] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> e1.weight - e2.weight);
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            int currNode = pq.peek().to;
            int currWeight = pq.remove().weight;

            if (dist[currNode] < currWeight) {
                continue;
            }

            for (Edge neighbor : graph.get(currNode)) {
                int nextNode = neighbor.to;
                int newWeight = dist[currNode] + neighbor.weight;

                if (newWeight < dist[nextNode]) {
                    dist[nextNode] = newWeight;
                    pq.add(new Edge(nextNode, newWeight));
                }
            }
        }

        return dist;
    }
}
