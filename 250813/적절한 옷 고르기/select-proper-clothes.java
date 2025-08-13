import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        int[] s = new int[n];
        int[] e = new int[n];
        int[] v = new int[n];
        for(int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine());
            s[i] = Integer.parseInt(stk.nextToken());
            e[i] = Integer.parseInt(stk.nextToken());
            v[i] = Integer.parseInt(stk.nextToken());
        }

        int[][] dp = new int[n][m];
        for(int i = 0; i < n; i++)
            dp[i][0] = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < s[i] -1; j++)
                dp[i][j] = -1;
            for(int j = e[i]; j < m; j++)
                dp[i][j] = -1;
        }

        for(int j = 1; j < m; j++) {
            for(int i = 0; i < n; i++) {
                if(dp[i][j] == -1)
                    continue;
                for(int k = 0; k < n; k++) {
                    if(dp[k][j-1] == -1)
                        continue;

                    int pomp = Math.abs(v[i] - v[k]);
                    dp[i][j] = Math.max(dp[i][j], dp[k][j-1] + pomp);
                }
            }
        }

        int answer = 0;
        for(int i = 0; i < n; i++) {
            answer = Math.max(answer, dp[i][m-1]);
        }

        System.out.println(answer);
    }
}