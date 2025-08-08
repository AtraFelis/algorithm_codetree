import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        int n = Integer.parseInt(br.readLine());
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++)
            Arrays.fill(dp[i], 1);

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int answer = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                
                for(int k = 0; k < 4; k++) {
                    int x = i + dx[k];
                    int y = j + dy[k];

                    if(x < 0 || y < 0 || x >= n || y >= n)
                        continue;

                    if(grid[i][j] > grid[x][y]) {
                        dp[i][j] = Math.max(dp[i][j], dp[x][y] + 1);
                        answer = Math.max(answer, dp[i][j]);
                    }
                }
            }
        }

        System.out.println(answer);
    }
}