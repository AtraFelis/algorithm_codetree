import java.util.*;

public class Main {

    static class Edge {
        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "[" + to + " " + weight + "]";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        char[][] brackets = new char[n+2][n+2];
        for (int i = 1; i < n+1; i++) {
            String row = sc.next();
            for (int j = 1; j < n+1; j++) {
                brackets[i][j] = row.charAt(j-1);
            }
        }

        for (int i = 0; i < n+2; i++) {
            brackets[0][i] = '.';
            brackets[i][0] = '.';
            brackets[n + 1][i] = '.';
            brackets[i][n + 1] = '.';
        }
        int start = 1;
        int end = n * n + 1;

        List<List<Edge>> graph = new ArrayList<>();
        for(int i = 0; i <= n*n; i++) {
            graph.add(new ArrayList<>());
        }

        int cnt = 0;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                cnt++;

                if(brackets[i - 1][j] != '.') {
                    int w = brackets[i][j] == brackets[i - 1][j] ? a : b;
                    graph.get(cnt).add(new Edge((i - 2) * n + j, w));
                }
                if(brackets[i + 1][j] != '.') {
                    int w = brackets[i][j] == brackets[i + 1][j] ? a : b;
                    graph.get(cnt).add(new Edge(i * n + j, w));
                }
                if(brackets[i][j-1] != '.') {
                    int w = brackets[i][j] == brackets[i][j - 1] ? a : b;
                    graph.get(cnt).add(new Edge((i - 1) * n + j - 1, w));
                }
                if(brackets[i][j+1] != '.') {
                    int w = brackets[i][j] == brackets[i][j + 1] ? a : b;
                    graph.get(cnt).add(new Edge((i - 1) * n + j + 1, w));
                }
            }
        }

        // for(int i = 1; i <= n*n; i++) {
        //     System.out.println(graph.get(i).toString());
        // }

        int len = n * n + 1;
        int ans = 0;
        for(int i = 1; i < len; i++) {

            int[] dist = new int[len];
            Arrays.fill(dist, (int)1e9);
            dist[i] = 0;

            PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> {
                return Integer.compare(e1.weight, e2.weight);
            });
            pq.add(new Edge(i, 0));

            // 다익스트라
            while(!pq.isEmpty()) {
                Edge edge = pq.remove();
                int currNode = edge.to;
                int currWeight = edge.weight;

                if (currWeight > dist[currNode]) {
                    continue;
                }

                for(Edge neighbor : graph.get(currNode)) {
                    int nextNode = neighbor.to;
                    int newWeight = neighbor.weight + dist[currNode];

                    if(dist[nextNode] > newWeight){
                        dist[nextNode] = newWeight;
                        pq.add(new Edge(nextNode, newWeight));  
                    }

                }
            }

            for(int j = 1; j < len; j++) {
                ans = Math.max(dist[j], ans);
            }

            // System.out.println(Arrays.toString(dist));
            // System.out.println(ans);
        }

        System.out.println(ans);
        
    }
}