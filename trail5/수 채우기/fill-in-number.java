import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        if(n == 1 || n == 3) {
            System.out.println(-1);
            return;
        }

        int ans = 0;
        ans += n / 5;
        n %= 5;

        if(n == 1 || n == 3) {
            n += 5;
            ans--;
        }

        ans += n /2;

        System.out.println(ans);
    }
}