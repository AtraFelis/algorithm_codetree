import java.util.*;
import java.io.*;

class Edge implements Comparable<Edge> {
    int to;
    int weight;

    public Edge (int to, int weight) {
        this.to = to;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge edge) {
        return Integer.compare(this.weight, weight);
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());
            int z = Integer.parseInt(stk.nextToken());

            graph.get(x).add(new Edge(y, z));
            graph.get(y).add(new Edge(x, z));
        }

        stk = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(stk.nextToken());
        int b = Integer.parseInt(stk.nextToken());

        int[] dist = new int[n + 1];
        Arrays.fill(dist, (int)1e9);
        dist[b] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(b, 0));

        while(!pq.isEmpty()) {
            Edge currEdge = pq.remove();
            int currNode = currEdge.to;
            int currWeight = currEdge.weight;

            if(dist[currNode] < currWeight)
                continue;

            for(Edge neighbor : graph.get(currNode)) {
                int nextNode = neighbor.to;
                int nextWeight = neighbor.weight;
                int newDist = nextWeight + dist[currNode];

                if(dist[nextNode] > newDist) {
                    dist[nextNode] = newDist;
                    pq.add(neighbor);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int ans = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 1; i < n; i++) {
            if(dist[i] < min) {
                min = dist[i];
                ans = i;
            }
        }
        sb.append(ans).append('\n');

        // System.out.println(Arrays.toString(dist));
        // System.out.println(sb);

        int idx = a;
        sb.append(idx).append(" ");
        while(idx != b) {
            for(Edge neighbor : graph.get(idx)) {
                if(neighbor.weight + dist[neighbor.to] == dist[idx]){
                    idx = neighbor.to;
                    break;    
                }
            }

            sb.append(idx).append(" ");
        }

        System.out.println(sb);
    }
}