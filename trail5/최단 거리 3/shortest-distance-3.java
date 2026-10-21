import java.util.*;

class Edge implements Comparable<Edge> {

    int to;
    int weight;

    public Edge(int n, int w) {
        this.to = n;
        this.weight = w;
    }

    @Override
    public int compareTo(Edge edge) {
        return Integer.compare(this.weight, edge.weight);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        List<List<Edge>> graph = new ArrayList<>();
        for(int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            graph.get(u).add(new Edge(v, w));
            graph.get(v).add(new Edge(u, w));
        }

        int a = sc.nextInt();
        int b = sc.nextInt();
        
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(a, 0));

        int[] dist = new int[n+1];
        Arrays.fill(dist, (int)1e9);
        dist[a] = 0;

        while(!pq.isEmpty()) {
            Edge edge = pq.remove();
            int currNode = edge.to;
            int currWeight = edge.weight;

            if(dist[currNode] < currWeight) {
                continue;
            }

            for(Edge neighbor : graph.get(currNode)) {
                int next = neighbor.to;
                int newWeight = neighbor.weight + dist[currNode];

                if(dist[next] > newWeight) {
                    dist[next] = newWeight;
                    pq.add(neighbor);
                }
            }
        }

        System.out.println(dist[b]);
    }
}