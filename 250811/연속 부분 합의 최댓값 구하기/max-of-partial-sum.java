import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        
        int[] dp = new int[n];
        Arrays.fill(dp, -1001);
        dp[0] = nums[0];
        for(int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], dp[i-1] + nums[i]);
        }

        int answer = -1001;
        for(int i : dp) {
            answer = Math.max(i, answer);
        }

        System.out.println(answer);
    }
}