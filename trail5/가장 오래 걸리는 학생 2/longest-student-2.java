import java.io.*;
import java.util.*;


class Edge implements Comparable<Edge> {

    int next;
    int weight;

    public Edge (int n, int w) {
        next = n;
        weight = w;
    }

    @Override
    public int compareTo(Edge e) {
        return Integer.compare(this.weight, e.weight);
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        ArrayList<Edge>[] graph = new ArrayList[n + 1];
        for(int i = 0; i < n + 1; i++)
            graph[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            int d = Integer.parseInt(stk.nextToken());

            graph[b].add(new Edge(a, d));
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(n, 0));
        int[] dist = new int[n + 1];
        Arrays.fill(dist, (int)1e9);
        dist[n] = 0;

        while(!pq.isEmpty()) {
            Edge edge = pq.poll();
            int currNode = edge.next;
            int currWeight = edge.weight;

            if(dist[currNode] < currWeight) 
                continue;

            for(Edge neighbor : graph[currNode]) {
                int nextNode = neighbor.next;
                int nextWeight = neighbor.weight;

                if(dist[nextNode] > dist[currNode] + nextWeight) {
                    dist[nextNode] = dist[currNode] + nextWeight;
                    pq.add(new Edge(nextNode, nextWeight));
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