import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int K = Integer.parseInt(stk.nextToken());

        String str = "#" + br.readLine();
        char[] crystal = str.toCharArray();

        int[][] dp = new int[N+1][K+1];
        for(int i = 1; i <= N; i++) {
            for(int j = 0; j <= K; j++) { 
                if(i < j) continue;
                
                // j가 짝수면 왼쪽, 홀수면 오른쪽
                if((j % 2 == 0 && crystal[i] == 'L') || (j % 2 == 1 && crystal[i] == 'R')) {
                    if(j - 1 < 0)
                        dp[i][j] = dp[i-1][j] + 1;
                    else
                        dp[i][j] = Math.max(dp[i-1][j] + 1, dp[i-1][j-1] + 1);
                } else {
                    if(j - 1 < 0)
                        dp[i][j] = dp[i-1][j];
                    else
                        dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]);
                }
            }
        }

        int ans = 0;
        for(int i = 0; i <= K; i++) {
            ans = Math.max(ans, dp[N][i]);
        }

        System.out.println(ans);
    }
}