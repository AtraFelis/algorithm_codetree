import java.util.Scanner;
public class Main {
    private static int n;
    private static int[] nums;
    private static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        nums = new int[n];
                
        backtracking(0, 0);
        System.out.println(answer);
    }

    private static void backtracking(int prevNum, int depth) {
        if(n == depth) {
            answer++;
            return;
        }

        for(int i = 1; i <= n; i++) {
            if(depth + i <= n) {
                for(int k = 0; k < i; k++) {
                    nums[depth + k] = i;
                }
                backtracking(i, depth + i);
            }
        }
    }
}