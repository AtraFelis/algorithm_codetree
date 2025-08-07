import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        int[] coin = new int[n];
        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            coin[i] = Integer.parseInt(stk.nextToken());
        
        Arrays.sort(coin);

        int[] dp = new int[m + 1];
        Arrays.fill(dp, 10001);
        for (int i = 0; i < n; i++)
            if(coin[i] <= m)
                dp[coin[i]] = 1;
        
        for(int i = coin[0]; i <= m; i++) {
            for(int j = 0; j < n; j++) {
                if(i + coin[j] > m) continue;
                dp[i + coin[j]] = Math.min(dp[i + coin[j]], dp[i] + 1);
            }
        }

        int answer = dp[m] != 10001 ? dp[m] : -1;
        System.out.println(answer);
    }
}