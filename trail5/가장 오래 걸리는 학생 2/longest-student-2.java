import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] graphR = new int[n+1][n+1]; //
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int d = sc.nextInt();

            graphR[b][a] = d;
        }
        
        int[] dist = new int[n + 1];
        boolean[] visited = new boolean[n + 1];

        Arrays.fill(dist, (int)1e9);
        dist[n] = 0;

        int node = n;
        for(int i = 1; i < n + 1; i++) {
            visited[node] = true;

            for(int j = 1; j < n + 1; j++) {
                if(visited[j])
                    continue;
                
                if(graphR[node][j] != 0)
                    dist[j] = Math.min(dist[j], graphR[node][j] + dist[node]);
            }

            int minDist = Integer.MAX_VALUE;
            for(int j = 1; j < n + 1; j++) {
                if(minDist > dist[j] && !visited[j]){
                    minDist = dist[j];
                    node = j;
                }
            }
        }

        int ans = 0;
        for(int i = 1; i < n; i++)
            ans = Math.max(ans, dist[i]);
        System.out.println(ans);
    }
}