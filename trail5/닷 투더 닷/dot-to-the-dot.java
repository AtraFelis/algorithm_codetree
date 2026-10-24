import java.io.*;
import java.util.*;

public class Main {
    public static class Edge {
        int to, L, C;

        public Edge(int to, int L, int C) {
            this.to = to;
            this.L = L;
            this.C = C;
        }
    }

    public static class State {
        int to, A, B;

        public State(int to, int A, int B) {
            this.to = to;
            this.A = A;
            this.B = B;
        }

        @Override
        public String toString() {
            return String.format("[%d %d %d]", to, A, B);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int I = Integer.parseInt(st.nextToken());
            int J = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            graph.get(I).add(new Edge(J, L, C)); // 초기 그래프에서는 L, C가 각각 최소 합산이므로
            graph.get(J).add(new Edge(I, L, C));
        }

        double[] dist = new double[n + 1];
        for (int i = 0; i < dist.length; i++) {
            dist[i] = 1e9;
        }
        dist[1] = 0;

        PriorityQueue<State> pq = new PriorityQueue<>((o1, o2) -> {
            double time1 = o1.B + (double) x / o1.A;
            double time2 = o2.B + (double) x / o2.A;
            return Double.compare(time1, time2);
        });
        pq.add(new State(1, 0, 0));

        while (!pq.isEmpty()) {

            PriorityQueue<State> copy = new PriorityQueue<>(pq);

            State state = pq.remove();
            int currNode = state.to;
            int currA = state.A;
            int currB = state.B;

            for (Edge neighbor : graph.get(currNode)) {
                int nextNode = neighbor.to;
                int nextA = currA == 0 ? neighbor.C : Math.min(currA, neighbor.C);
                int nextB = currB + neighbor.L;

                double newDist = nextB + (double) x / nextA;
                if (dist[nextNode] >= newDist) {
                    dist[nextNode] = newDist;
                    pq.add(new State(nextNode, nextA, nextB));
                }
            }
        }

        System.out.println((int) dist[n]);

    }
}