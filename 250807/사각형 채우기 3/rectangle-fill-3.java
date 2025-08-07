import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long[] dp = new long[1001];

        dp[1] = 2;
        dp[2] = 7;
        // dp[3] = dp[3 - 1] * 2 + dp[3 - 2] * 3 + 2;
        // dp[4] = dp[4 - 1] * 2 + dp[4 - 2] * 3 + dp[4 - 3] * 2 + 2;

        for(int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] * 2 % 1000000007 + dp[i - 2] * 3 % 1000000007;
            for(int j = 1; j < i - 2; j++) {
                dp[i] += dp[j] * 2 % 1000000007;
            }
            dp[i] = (dp[i] + 2) % 1000000007;
        }

        System.out.println(dp[n]);
    }
}