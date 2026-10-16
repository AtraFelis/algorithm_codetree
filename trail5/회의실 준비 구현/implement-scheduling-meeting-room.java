import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        int n = Integer.parseInt(br.readLine());
        int[][] meetings = new int[n][2];
        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine());
            meetings[i][0] = Integer.parseInt(stk.nextToken());
            meetings[i][1] = Integer.parseInt(stk.nextToken());
        }

        Arrays.sort(meetings, (m1, m2) -> Integer.compare(m1[1], m2[1]));

        int ans = 1;
        int curEnd = meetings[0][1];
        for (int i = 1; i < n; i++) {
            if(meetings[i][0] < curEnd) continue;
            else {
                ans++;
                curEnd = meetings[i][1];
            }
        }

        System.out.println(ans);
    }
}