import java.util.*;

public class Main {
    private static int k, n;
    private static int[] num;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        n = sc.nextInt();
        
        num = new int[n];

        backtracking(0);
    }

    private static void backtracking(int depth) {
        if(depth == n) {
            StringBuilder sb = new StringBuilder();
            for(int o : num) {
                sb.append(o).append(" ");
            }
            System.out.println(sb);
            return;
        }

        for(int i = 1; i <= k; i++) {
            if(depth >= 2 && num[depth - 1] == num[depth - 2] && num[depth - 1] == i) {
                continue;
            }
            
            num[depth] = i;
            backtracking(depth + 1);
        }
    }
}