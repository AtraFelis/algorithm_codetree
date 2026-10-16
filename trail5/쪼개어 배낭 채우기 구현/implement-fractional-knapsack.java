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
            return Double.compare((double)j1[1]/j1[0], (double)j2[1]/j2[0]);
        });
        

        // for(int i = 0; i < n; i++)
        //     System.out.println(jewel[i][0] + " " + jewel[i][1] + " " + ((float)jewel[i][1]/jewel[i][0]));

        double ans = 0;
        for(int i = 0; i < n; i++) {
            int w = jewel[i][0];
            int v = jewel[i][1];

            if(m >= w) {
                m -= w;
                ans += v;
            } else {
                ans += (double)v / w * m;
                break;
            }
        }

        System.out.printf("%.3f", ans);
    }
}