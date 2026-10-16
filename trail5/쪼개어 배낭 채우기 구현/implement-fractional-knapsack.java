import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] jewel = new int[n][2];
        for (int i = 0; i < n; i++) {
            jewel[i][0] = sc.nextInt();
            jewel[i][1] = sc.nextInt();
        }
        
        Arrays.sort(jewel, (j2, j1) -> {
            return Integer.compare(j1[1]/j1[0], j2[1]/j2[0]);
        });

        int curW = 0;
        int idx = 0;
        while(curW <= m) {
            curW += jewel[idx++][0];
        }
        curW -= jewel[--idx][0];

        float ans = 0;
        for(int i = 0; i < idx; i++) {
            ans += jewel[i][1];
        }
        ans += (float)jewel[idx][1] / jewel[idx][0] * (m - curW);

        System.out.printf("%.3f", ans);
    }
}