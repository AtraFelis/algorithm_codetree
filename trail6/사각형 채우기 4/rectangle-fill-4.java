import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int[] dp = new int[1001];

        if(n % 2 == 1) {
            System.out.println(0);
            return;
        }

        dp[0] = 1;
        dp[2] = 3;

        for(int i = 4; i <= n; i+=2) {
            dp[i] = dp[i-2] * 3 + dp[i-4] * 2;
        }

        System.out.println(dp[n]);
    }
}