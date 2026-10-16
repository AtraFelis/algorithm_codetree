import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] meetings = new int[n][2];
        for (int i = 0; i < n; i++) {
            meetings[i][0] = sc.nextInt();
            meetings[i][1] = sc.nextInt();
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