import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        
        int[] coins = new int[n + 1];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            coins[i] = Integer.parseInt(stk.nextToken());
        }

        int[][] dp = new int[n+1][4];
        for(int i = 1; i < n + 1; i++) {
            if(i % 2 == 0) dp[i][0] = dp[i-2][0] + coins[i];
            else dp[i][0] = 0;
        }
        for(int i = 1; i < 4; i++) {
            dp[1][i] = coins[1];
        }

        for(int i = 1; i <= 3; i++) {
            for(int j = 2; j < n + 1; j++) {
                dp[j][i] = Math.max(dp[j-1][i-1], dp[j-2][i]) + coins[j];
            }
        }

        int ans = 0;
        for(int i : dp[n]) {
            ans = Math.max(i, ans);
        }

        System.out.println(ans);
    }
}