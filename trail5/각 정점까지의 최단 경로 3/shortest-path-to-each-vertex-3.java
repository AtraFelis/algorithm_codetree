import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] graph = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt(); // 시작 정점
            int v = sc.nextInt(); // 끝 정점
            int w = sc.nextInt(); // 가중치

            graph[u][v] = w;
        }
        
        int[] dist = new int[n + 1];
        for(int i = 0; i < n + 1; i++) {
            dist[i] = (int)1e9;
        }
        
        boolean[] visited = new boolean[n + 1];
        dist[1] = 0;

        int curNode = 1;
        for (int i = 1; i <= n; i++) {
    
            visited[curNode] = true;

            for(int j = 1; j <= n; j++) {
                if(graph[curNode][j] != 0 && !visited[j]) {
                    dist[j] = Math.min(dist[j], dist[curNode] + graph[curNode][j]);
                }
            }

            int min = Integer.MAX_VALUE;
            for(int j = 1; j <= n; j++) {
                if(!visited[j] && min > dist[j]) {
                    min = dist[j];
                    curNode = j;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        // System.out.println(Arrays.toString(dist));
        for (int i = 2; i <= n; i++) {
            sb.append(dist[i] == (int)1e9 ? -1 : dist[i]).append('\n');
        }
        System.out.println(sb);
    }
}