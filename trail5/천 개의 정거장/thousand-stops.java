import java.util.*;

class Edge implements Comparable<Edge> {
    int bus;
    int to;

    public Edge(int bus, int n) {
        this.bus = bus;
        this.to = n;
    }

    @Override
    public int compareTo(Edge edge) {
        return Integer.compare(this.to, edge.to);
    }
}

class Passenger {
    int bus;
    int node;
    int totalCost;
    int totalTime;

    public Passenger(int bus, int n, int totalCost, int totalTime) {
        this.bus = bus;
        this.node = n;
        this.totalCost = totalCost;
        this.totalTime = totalTime;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int N = sc.nextInt();

        List<List<Edge>> graph = new ArrayList<>();
        for(int i = 0; i < 101; i++) {
            graph.add(new ArrayList<>());
        }

        int[] costs =  new int[N];
        for (int i = 0; i < N; i++) {
            costs[i] = sc.nextInt();
            int stopCount = sc.nextInt();
            int prevStop = sc.nextInt();
            for (int j = 1; j < stopCount; j++) {
                int stop = sc.nextInt();
                graph.get(prevStop).add(new Edge(i, stop));
                prevStop = stop;
            }
        }
        
        // 1. 모든 경로 찾기
        Queue<Passenger> q = new LinkedList<>();
        q.add(new Passenger(-1, A, 0, 0)); // 이전에 타고 있던 버스, 현재 지점 (안 타고 있었으므로 -1)

        long minCost = Long.MAX_VALUE;
        long minTime = Long.MAX_VALUE;

        boolean[] visited = new boolean[101];

        while(!q.isEmpty()) {
            Passenger p = q.remove();

            visited[p.node] = true;

            for(Edge neighbor : graph.get(p.node)) {
                int nextBus = neighbor.bus;
                int nextNode = neighbor.to;
                int newTotalCost = p.totalCost;

                if(visited[nextNode])
                    continue;

                if(nextBus != p.bus) { // 버스가 다르면 환승
                    newTotalCost += costs[nextBus];
                }

                if(nextNode == B && minCost > newTotalCost) { // 만약 다음 지점이 도착지라면
                    minCost = newTotalCost;
                    minTime = p.totalTime + 1;
                    continue; // 도착했으므로 큐에 추가 안 하고 넘김
                } else if(nextNode == B && minCost == newTotalCost) {
                    minTime = Math.min(minTime, p.totalTime + 1);
                    continue;
                }

                q.add(new Passenger(nextBus, nextNode, newTotalCost, p.totalTime + 1));
            }
        }

        if(minCost == Long.MAX_VALUE || minTime == Long.MAX_VALUE) {
            minCost = -1;
            minTime = -1;
        }
        
        System.out.println(minCost + " " + minTime);
    }
}