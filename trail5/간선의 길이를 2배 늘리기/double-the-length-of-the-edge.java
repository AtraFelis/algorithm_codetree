import java.util.*;

public class Main {
    public static class Edge {
        int to;
        long weight;

        public Edge(int to, long weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "[" + to + " " + weight + "] ";
        }
    }

    private static final int MAX_N = 250;

    private static int n, m;

    private static int[] path;;
    private static long[] dist;
    private static List<List<Edge>> graph = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            graph.get(u).add(new Edge(v, w));
            graph.get(v).add(new Edge(u, w));
        }

        // 1. 1 -> N 까지 최단 거리 및 이때 지나는 Edge 기록 
        // (지나지 않는 경로의 Edge의 거리를 두 배로 늘려봤자, 최단 거리에는 영향을 주지 않음)
        // 2.경로 중에서 가장 큰 가중치를 찾은 후, 그 edge의 가중치를 2배로 증가
        // 3. 이 상태로 다익스트라 한 번 더
        // 4. 3번 최단거리 - 1번 최단거리 => 정답

        path = new int[n + 1];
        dist = new long[n + 1];

        dijkstra();
        int[] originalPath = path.clone();
        long ans = dist[n];

        int idx = n;
        long maxDist = 0;
        // path 따라서 가중치 순회
        while(idx != 1) {
            int prev = originalPath[idx];
            // prev -> idx 가중치
            for(Edge edge : graph.get(prev)) {
                if(edge.to == idx) {
                    edge.weight *= 2;
                    dijkstra();
                    edge.weight /= 2;

                    maxDist = Math.max(maxDist, dist[n]);
                    break;
                }
            }

            idx = path[idx];
        }

        ans = maxDist - ans;
        System.out.println(ans);
    }

    private static void dijkstra() {
        Arrays.fill(dist, (long)1e12);
        dist[1] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> Long.compare(e1.weight, e2.weight));

        pq.add(new Edge(1, 0));

        while(!pq.isEmpty()) {
            Edge edge = pq.remove();
            int currNode = edge.to;
            long currWeight = edge.weight;

            if(currNode == n)
                break;

            if(dist[currNode] < currWeight)
                continue;

            for(Edge neighbor : graph.get(currNode)) {
                int nextNode = neighbor.to;
                long newWeight = dist[currNode] + neighbor.weight;

                if(dist[nextNode] > newWeight) {
                    pq.add(new Edge(nextNode, newWeight));
                    dist[nextNode] = newWeight;
                    path[nextNode] = currNode;
                }
            }
        }
    }
}