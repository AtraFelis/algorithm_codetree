import java.util.*;
import java.io.*;

public class Main {

    public static class Edge {
        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static List<List<Edge>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for(int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            
            graph.get(x).add(new Edge(y, w));
            graph.get(y).add(new Edge(x, w));
        }

        // ABC를 시작점으로 하는 다익스트라 세 번
        int distA[] = dijkstra(a);
        int distB[] = dijkstra(b);
        int distC[] = dijkstra(c);

        // System.out.println(Arrays.toString(distA));
        // System.out.println(Arrays.toString(distB));
        // System.out.println(Arrays.toString(distC));

        int ans = 0;
        for(int i = 1; i <= n; i++) {
            int minDist = Integer.MAX_VALUE;

            minDist = Math.min(distA[i], distB[i]);
            minDist = Math.min(minDist, distC[i]);

            ans = Math.max(ans, minDist);
        }

        System.out.println(ans);
    }

    public static int[] dijkstra(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> Integer.compare(e1.weight, e2.weight));
        pq.add(new Edge(start, 0));

        int[] dist = new int[graph.size() + 1];
        for(int i = 0; i < dist.length; i++) {
            dist[i] = (int)1e9;
        }
        dist[start] = 0;
        
        while(!pq.isEmpty()) {
            Edge edge = pq.remove();
            int currNode = edge.to;
            int currWeight = edge.weight;

            for(Edge neighbor : graph.get(currNode)) {
                int nextNode = neighbor.to;
                int newWeight = neighbor.weight + dist[currNode];

                if(dist[nextNode] < newWeight)
                    continue;

                dist[nextNode] = newWeight;
                pq.add(new Edge(nextNode, newWeight));
            }
        }

        return dist;
    }
}