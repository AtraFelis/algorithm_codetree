import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        int[][] dp = new int[n][n];
        dp[0][0] = matrix[0][0];

        for(int i = 0; i < n; i++) {
            for(int k = 0; k < n; k++) {
                if(i == 0 && k == 0) continue;

                if(i - 1 >= 0)
                    dp[i][k] = Math.max(dp[i][k], dp[i-1][k] + matrix[i][k]);

                if(k - 1 >= 0)
                    dp[i][k] = Math.max(dp[i][k], dp[i][k-1] + matrix[i][k]);
            }
        }

        System.out.println(dp[n-1][n-1]);
    }
}