import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static class Edge {
        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int w = sc.nextInt();

            graph.get(a).add(new Edge(b, w));
            graph.get(b).add(new Edge(a, w));
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, (int) 1e9);
        dist[n] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> e1.weight - e2.weight);
        pq.add(new Edge(n, 0));

        while (!pq.isEmpty()) {
            Edge edge = pq.remove();
            int currNode = edge.to;
            int currWeight = edge.weight;

            if (dist[currNode] < currWeight)
                continue;

            for (Edge neighbor : graph.get(currNode)) {
                int nextNode = neighbor.to;
                int newWeight = neighbor.weight + dist[currNode];

                if (dist[nextNode] > newWeight) {
                    dist[nextNode] = newWeight;
                    pq.add(new Edge(nextNode, newWeight));
                }
            }
        }
        
        int ans = 0;
        for(int i = 1; i < n; i++) {
            ans = Math.max(ans, dist[i]);
        }

        System.out.println(ans);
    }
}