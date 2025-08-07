import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(stk.nextToken());

        int[] dp = new int[n]; // 해당 인덱스를 시작점으로 하는 가장 긴 증가하는 부분 수열의 길이를 저장

        if(n == 1) {
            System.out.println(1);
            return;
        }

        Arrays.fill(dp, 1);
        for(int i = n-2; i >= 0; i--) {
            for(int j = i + 1; j < n; j++) {    
                if(arr[i] < arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int answer = 0;
        for(int i : dp) {
            answer = Math.max(answer, i);
        }

        System.out.println(answer);
    }
}