import java.util.Scanner;
public class Main {
    private static int n;
    private static int[] nums;
    private static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        nums = new int[n];

        backtracking(0);
        System.out.println(answer);
    }

    private static void backtracking(int depth) {
        if(n == depth) {
            // for(int num : nums) {
            //     System.out.print(num);
            // }
            // System.out.println();
            answer++;
            return;
        }

        for(int i = 1; i <= 4; i++) {
            if(depth + i <= n) {
                for(int k = 0; k < i; k++) {
                    nums[depth + k] = i;
                }
                backtracking(depth + i);
            }
        }
    }
}