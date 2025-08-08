import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++){
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++)
                grid[i][j] = Integer.parseInt(stk.nextToken());
        }

        int[][] dp = new int[n][m];
        for(int i = 0; i < n; i++)
            dp[i][0] = 0;
        for(int i = 0; i < m; i++)
            dp[0][i] = 0;
        dp[0][0] = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {                
                for(int k = 0; k < i; k++) {
                    for(int l = 0; l < j; l++) {
                        if(grid[i][j] <= grid[k][l] || dp[k][l] == 0)
                            continue;
                        dp[i][j] = Math.max(dp[i][j], dp[k][l] + 1);
                    }
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                answer = Math.max(answer, dp[i][j]);

        System.out.println(answer);
    }
}