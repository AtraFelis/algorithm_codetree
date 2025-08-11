import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        int[] arr = new int[n];
        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        int[] dp = new int[m+1];
        for(int i = 0; i <= m; i++) {
            dp[i] = n+1;
        }
        dp[0] = 0;

        for(int i = 0; i < n; i++) {
            for(int j = m; j >= 0; j--) {
                if(j >= arr[i]) {
                    if(dp[j - arr[i]] == 10001) continue;
                    dp[j] = Math.min(dp[j], dp[j - arr[i]] + 1);
                }
            }
        }

        System.out.println(dp[m] != n + 1 ? dp[m] : -1);
    }
}