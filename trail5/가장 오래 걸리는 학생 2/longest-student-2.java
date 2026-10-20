import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<int[]>[] graphR = new ArrayList[n+1];
        for(int i = 0; i < n + 1; i++)
            graphR[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int d = sc.nextInt();

            graphR[b].add(new int[]{a, d});
        }
        
        int[] dist = new int[n + 1];
        boolean[] visited = new boolean[n + 1];

        Arrays.fill(dist, (int)1e9);
        dist[n] = 0;

        int node = n;
        for(int i = 1; i < n + 1; i++) {
            visited[node] = true;

            for(int[] next : graphR[node]) {
                if(visited[next[0]])
                    continue;
                
                dist[next[0]] = Math.min(dist[next[0]],  dist[node] + next[1]);
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