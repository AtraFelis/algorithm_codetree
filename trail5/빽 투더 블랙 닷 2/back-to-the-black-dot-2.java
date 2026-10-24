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

    public static List<List<Edge>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int red1 = Integer.parseInt(st.nextToken());
        int red2 = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(u).add(new Edge(v, w));
            graph.get(v).add(new Edge(u, w));
        }
    
        // start -> red1 -> red2 -> start
        // 양방향이므로 i -> red1이나 red1 -> i나 같음
        int[] distRed1 = dijkstra(red1);
        int[] distRed2 = dijkstra(red2);

        // System.out.println(Arrays.toString(distRed1));
        // System.out.println(Arrays.toString(distRed2));

        long ans = Integer.MAX_VALUE;
        for(int i = 1; i <= n; i++) {
            if(i == red1 || i == red2)
                continue;

            ans = Math.min(ans, (long)distRed1[i] + distRed1[red2] + distRed2[i]);
        }

        System.out.println(ans < (long)1e9 ? ans : -1);
    }

    public static int[] dijkstra(int start) {
        int[] dist = new int[graph.size()];
        for(int i = 0; i < graph.size(); i++) {
            dist[i] = (int)1e9;
        }
        dist[start] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) ->
            Integer.compare(e1.weight, e2.weight)
        );
        pq.add(new Edge(start, 0));

        while(!pq.isEmpty()) {
            Edge edge = pq.remove();
            int currNode = edge.to;
            int currWeight = edge.weight;

            if(dist[currNode] < currWeight)
                continue;
            
            for(Edge neighbor : graph.get(currNode)) {

                int nextNode = neighbor.to;
                int newWeight = dist[currNode] + neighbor.weight;

                if(dist[nextNode] > newWeight) {
                    pq.add(new Edge(nextNode, newWeight));
                    dist[nextNode] = newWeight;
                }
            }
        }

        return dist;
    }
}
