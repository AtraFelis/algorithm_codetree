import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int min = Integer.MAX_VALUE, max = 0;

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            min = Math.min(y, min);
            max = Math.max(y, max);
        }

        System.out.println(min + max);
    }
}