import java.util.*;

class Edge implements Comparable<Edge> {
    int node, weight;

    public Edge(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge e) {
        return Integer.compare(this.weight, e.weight);
    }


    @Override
    public String toString() {
        return String.format("[%d, %d]", node, weight);
    }
} 

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        List<Edge>[] graph = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++)
            graph[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            graph[u].add(new Edge(v, w));
            graph[v].add(new Edge(u, w));
        }

        int[] dist = new int[n + 1];
        for(int i = 1; i < n + 1; i++) {
            dist[i] = (int)1e9;
        }
        dist[k] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(k, 0));

        while(!pq.isEmpty()) {

            // PriorityQueue<Edge> tempPq = new PriorityQueue<>(pq);
            // while (!tempPq.isEmpty()) {
            //     System.out.print(tempPq.poll().toString() + " ");
            // }
            // System.out.println(" | " + Arrays.toString(dist));

            Edge edge = pq.remove();
            int node = edge.node;
            int weight = edge.weight; 
            
            if(dist[node] < weight)
                continue;

            for(int i = 0; i < graph[node].size(); i++) {
                int d = graph[node].get(i).node;
                int w = graph[node].get(i).weight;

                if (dist[d] > dist[node] + w) {
                    dist[d] = dist[node] + w;
                    pq.add(new Edge(d, dist[d]));
                }
            }
        }

        for(int i = 1; i < n+1; i++) {
            System.out.println(dist[i] != (int)1e9 ? dist[i] : -1);
        }
    }
}