import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = sc.nextInt();
        }
        
        int ans = a[0], sum = a[0];
        for (int i = 1; i < N; i++) {
            if(sum < 0)
                sum = 0;
            sum += a[i];
            ans = Math.max(ans, sum);
        }

        System.out.println(ans);
    }
}