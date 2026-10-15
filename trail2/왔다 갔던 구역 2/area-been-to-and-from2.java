import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] lines = new int[2001];
        int pos = 1000;

        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            char dir = sc.next().charAt(0);

            for(int j = 0; j < x; j++) {
                if(dir == 'R') {
                    lines[pos++] += 1;
                } else {
                    lines[--pos] += 1;
                }
            }
        }

        int ans = 0;
        for(int i = 0; i < 2001; i++) {
            if(lines[i] >= 2) ans++;
        }

        System.out.println(ans);
    }
}