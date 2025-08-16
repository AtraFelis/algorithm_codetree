import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n * 2 + 1][n + 1];

        for (int i = 1; i <= 2 * n; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int red = Integer.parseInt(stk.nextToken());
            int blue = Integer.parseInt(stk.nextToken());

            for(int j = 0; j <= n; j++) {
                if(i < j) break;
                if(i > n && i - n > j) continue;
                
                if(j == 0)
                    dp[i][j] = dp[i-1][j] + blue;
                else
                    dp[i][j] = Math.max(dp[i-1][j] + blue, dp[i-1][j-1] + red);
            }
        }

        System.out.println(dp[n*2][n]);
    }
}