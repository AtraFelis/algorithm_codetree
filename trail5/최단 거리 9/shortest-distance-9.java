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

        // 양방향 그래프
        ArrayList<Edge>[] graph = new ArrayList[n+1];
        for(int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(stk.nextToken());
            int v = Integer.parseInt(stk.nextToken());
            int w = Integer.parseInt(stk.nextToken());

            graph[u].add(new Edge(v, w));
            graph[v].add(new Edge(u, w));
        }

        stk = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(stk.nextToken());
        int b = Integer.parseInt(stk.nextToken());

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(b, 0));

        int[] dist = new int[n+1];
        Arrays.fill(dist, (int)1e9);
        dist[b] = 0;

        int[] path = new int[n+1];

        while(!pq.isEmpty()) {
            Edge e = pq.remove();
            int currNode = e.to;
            int currWeight = e.weight;

            if(dist[currNode] < currWeight)
                continue;

            for(Edge neighbor : graph[currNode]) {
                int newWeight = dist[currNode] + neighbor.weight;

                if(dist[neighbor.to] > newWeight) {
                    dist[neighbor.to] = newWeight;
                    pq.add(neighbor);
                    path[neighbor.to] = currNode;
                }
            }
        }

        // System.out.println(Arrays.toString(dist));
        // System.out.println(Arrays.toString(path));

        StringBuilder sb = new StringBuilder();
        sb.append(dist[a]).append('\n');

        int idx = a;
        for(int i = 1; i < n + 1; i++) {
            sb.append(idx).append(" ");
            idx = path[idx];

            if(idx == 0) break;
        }

        System.out.println(sb);
    }
}