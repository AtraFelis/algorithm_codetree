import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        
        int[] nums = new int[n];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(stk.nextToken());
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