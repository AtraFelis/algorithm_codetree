import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static int[] dist;
    private static List<List<Edge>> graph = new ArrayList<>();

    private static int n, m;

    private static class Edge implements Comparable<Edge> {
        int to;
        int weight;
        boolean flag = false;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge e) {
            return Integer.compare(this.weight, e.weight);
        }
    }

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
            int w = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Edge(b, w));
            graph.get(b).add(new Edge(a, w));
        }

        dist = new int[n + 1];
        dijkstra();
        int originalDist = dist[n];
        // System.out.println(Arrays.toString(dist));

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (Edge e : graph.get(i)) {

                // 이미 끊었던 기록이 있는 간선이면 넘어감
                if (e.flag)
                    continue;

                Edge e2 = new Edge(0, 0);
                for (int j = 0; j < graph.get(e.to).size(); j++) {
                    e2 = graph.get(e.to).get(j);
                    if (e2.to == i) {
                        break;
                    }
                }

                int tmp = e.weight;
                e.weight = 0;
                e2.weight = 0;

                e.flag = true;
                e2.flag = true;

                dijkstra();

                // System.out.printf("(%d, %d) (%d, %d)\n", i, e.to, e.to, e2.to);

                // System.out.println("그래프");
                // for (int x = 1; x <= n; x++) {
                // for (Edge abc : graph.get(x)) {
                // System.out.printf("(%d, %d, %d) ", x, abc.to, abc.weight);
                // }
                // }
                // System.out.println();

                e.weight = tmp;
                e2.weight = tmp;

                // System.out.println("그래프");
                // for (int x = 1; x <= n; x++) {
                // for (Edge abc : graph.get(x)) {
                // System.out.printf("(%d, %d, %d) ", x, abc.to, abc.weight);
                // }
                // }
                // System.out.println();

                // 아예 못 가게 되는 경우도 포함
                if (originalDist != dist[n])
                    ans++;

                // System.out.println(Arrays.toString(dist));
                // System.out.println("\n--------------------------\n");
            }
        }

        System.out.println(ans);

    }

    // flag == true : path 기록
    private static void dijkstra() {
        dist = new int[n + 1];

        Arrays.fill(dist, (int) 1e9);
        dist[1] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(1, 0));

        while (!pq.isEmpty()) {
            Edge e = pq.remove();
            int currNode = e.to;
            int currWeight = e.weight;

            if (dist[currNode] < currWeight)
                continue;

            for (Edge neighbor : graph.get(currNode)) {
                if (neighbor.weight == 0)
                    continue;

                int next = neighbor.to;
                int newWeight = dist[currNode] + neighbor.weight;

                if (dist[next] > newWeight) {
                    dist[next] = newWeight;
                    pq.add(new Edge(next, newWeight));
                }
            }
        }
    }
}
