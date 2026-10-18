import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        int n = sc.nextInt();
        int[] redStones = new int[c];
        for (int i = 0; i < c; i++) {
            redStones[i] = sc.nextInt();
        }
        Integer[][] blackStones = new Integer[n][2];
        for (int i = 0; i < n; i++) {
            blackStones[i][0] = sc.nextInt();
            blackStones[i][1] = sc.nextInt();
        }
        
        Arrays.sort(redStones);
        Arrays.sort(blackStones, (s1, s2) -> {
            if (s1[0] == s2[0])
                return Integer.compare(s1[1], s2[1]);
            return Integer.compare(s1[0], s2[0]); 
        });

        // System.out.println(Arrays.toString(redStones));
        // for(int i = 0; i < blackStones.length; i++) {
        //     System.out.println(Arrays.toString(blackStones[i]));
        // }

        int bIdx = 0;
        int ans = 0;
        for(int rIdx = 0; rIdx < c; rIdx++) {

            int redNum = redStones[rIdx];
            // System.out.println(redNum); 

            for(int i = bIdx; i < n; i++) {
                int start = blackStones[i][0];
                int end = blackStones[i][1];

                // System.out.printf("%d %d\n", start, end);

                if(start <= redNum && redNum <= end) {
                    // System.out.printf("%d : %d %d\n", redNum, start, end);
                    ans++;
                    bIdx = i + 1;
                    break;
                }
            }
        }

        System.out.println(ans);
    }
}