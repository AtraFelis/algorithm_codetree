import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] prices = new int[n];
        for(int i = 0; i < n; i++)
            prices[i] = sc.nextInt();

        int max = 0, ans = 0;        
        for(int i = n-1; i >= 0; i--) {
            ans = Math.max(ans, max - prices[i]);
            max = Math.max(prices[i], max);
        }

        System.out.println(ans);
    }
}