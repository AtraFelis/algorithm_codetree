import java.util.*;

public class Main {
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
        // for (int i = 0; i < n+2; i++) {
        //     System.out.println(Arrays.toString(brackets[i]));
        // }
        int start = 1;
        int end = n * n + 1;

        int[][] graph = new int[n * n + 1][n * n + 1];
        for(int i = 0; i <= n*n; i++) {
            Arrays.fill(graph[i], -1);
        }

        int cnt = 0;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                cnt++;
                graph[cnt][cnt] = 0;

                if(brackets[i - 1][j] != '.') {
                    graph[cnt][cnt-3] = brackets[i][j] == brackets[i - 1][j] ? a : b;
                }
                if(brackets[i + 1][j] != '.') {
                    graph[cnt][cnt+3] = brackets[i][j] == brackets[i + 1][j] ? a : b;
                }
                if(brackets[i][j-1] != '.') {
                    graph[cnt][cnt-1] = brackets[i][j] == brackets[i][j - 1] ? a : b;
                }
                if(brackets[i][j+1] != '.') {
                    graph[cnt][cnt+1] = brackets[i][j] == brackets[i][j + 1] ? a : b;
                }
            }
        }

        // for(int i = 1; i <= n*n; i++) {
        //     System.out.println(Arrays.toString(graph[i]));
        // }

        int len = n * n + 1;
        int ans = 0;
        for(int i = 1; i < len; i++) {
            boolean[] visited = new boolean[len];
            int[] dist = new int[len];
            Arrays.fill(dist, (int)1e9);
            dist[i] = 0;

            // 다익스트라
            for(int j = 1; j < len; j++) {
                
                int minIdx = -1;
                for(int k = 1; k < len; k++) {
                    if(visited[k])
                        continue;

                    if(minIdx == -1 || dist[minIdx] > dist[k]){
                        minIdx = k;
                    }
                }
                
                visited[minIdx] = true;

                for(int k = 1; k < len; k++) {
                    if(graph[minIdx][k] == -1)
                        continue;

                    dist[k] = Math.min(dist[k], graph[minIdx][k] + dist[minIdx]);
                }

                // System.out.println(Arrays.toString(dist));

            }

            // System.out.println(Arrays.toString(dist));

            for(int j = 1; j < len; j++) {
                ans = Math.max(dist[j], ans);
            }
        }

        System.out.println(ans);
        
    }
}