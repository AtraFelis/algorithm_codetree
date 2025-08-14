import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        int[] w = new int[n];
        int[] v = new int[n];
        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(stk.nextToken());
            v[i] = Integer.parseInt(stk.nextToken());
        }

        int[] dp = new int[m+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for(int i = 0; i < n; i++) {
            for(int j = m; j >= w[i]; j--) {
                if(dp[j - w[i]] != -1 || j - w[i] <= m)
                    dp[j] = Math.max(dp[j], dp[j - w[i]] + v[i]);
            }
        }

        int ans = 0;
        for(int i : dp) {
            ans = Math.max(ans, i);
        }

        System.out.println(ans);
    }
}