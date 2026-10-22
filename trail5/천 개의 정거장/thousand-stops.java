
import java.io.*;
import java.util.*;

public class Main {

    static class Bus {
        long cost;
        int[] route;
        
        public Bus(long cost, int[] route) {
            this.cost = cost;
            this.route = route;
        }
    }

    static class StopInfo {
        int busId;
        int index;
        
        public StopInfo(int busId, int index) {
            this.busId = busId;
            this.index = index;
        }
    }

    static class State {
        int node;
        long cost;
        long time;

        public State(int node, long cost, long time) {
            this.node = node;
            this.cost = cost;
            this.time = time;
        }
    }

    static List<Bus> buses = new ArrayList<>();
    static List<StopInfo>[] stops = new ArrayList[1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= 1000; i++) {
            stops[i] = new ArrayList<>();
        }

        // 1. 버스 노선 입력
        for (int busId = 0; busId < N; busId++) {
            st = new StringTokenizer(br.readLine());

            long cost = Long.parseLong(st.nextToken());
            int count = Integer.parseInt(st.nextToken());

            int[] route = new int[count];
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < count; i++) {
                route[i] = Integer.parseInt(st.nextToken());
                stops[route[i]].add(new StopInfo(busId, i));
            }

            buses.add(new Bus(cost, route));
        }

        // 2. 최소 비용과 시간 초기화
        long[] minCost = new long[1001];
        long[] minTime = new long[1001];

        Arrays.fill(minCost, Long.MAX_VALUE);
        Arrays.fill(minTime, Long.MAX_VALUE);

        minCost[A] = 0;
        minTime[A] = 0;

        // 3. 우선순위 큐
        PriorityQueue<State> pq = new PriorityQueue<>(
                (a, b) -> {
                    if (a.cost != b.cost) {
                        return Long.compare(a.cost, b.cost);
                    }
                    return Long.compare(a.time, b.time);
                });

        pq.offer(new State(A, 0, 0));

        // 4. 다익스트라 알고리즘
        while (!pq.isEmpty()) {
            State current = pq.poll();

            int node = current.node;
            long cost = current.cost;
            long time = current.time;

            if (cost > minCost[node] || (cost == minCost[node] && time > minTime[node])) {
                continue;
            }

            // 현재 정류장에서 탑승할 수 있는 버스
            for (StopInfo info : stops[node]) {

                Bus bus = buses.get(info.busId);
                int currentIndex = info.index;
                int[] route = bus.route;

                // 해당 버스에서 내릴 수 있는 정류장
                for (int i = currentIndex + 1; i < route.length; i++) {

                    int next = route[i];

                    long newCost = cost + bus.cost;
                    long newTime = time + (i - currentIndex);

                    if (newCost < minCost[next] ||
                            (newCost == minCost[next] && newTime < minTime[next])) {

                        minCost[next] = newCost;
                        minTime[next] = newTime;

                        pq.offer(new State(next, newCost, newTime));
                    }
                }
            }
        }

        // 5. 결과 출력
        if (minCost[B] == Long.MAX_VALUE) {
            System.out.println("-1 -1");
        } else {
            System.out.println(minCost[B] + " " + minTime[B]);
        }
    }
}