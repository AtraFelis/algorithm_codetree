import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int answer = 0;
        for (int i = 0; i < n-2; i++) {
            for(int j = 0; j < n-2; j++) {
                int tmp = 0;
                for(int k = 0; k < 3; k++) {
                    if (grid[i][j+k] == 1) tmp++;
                    if (grid[i+1][j+k] == 1) tmp++;
                    if (grid[i+2][j+k] == 1) tmp++;
                }

                answer = answer > tmp ? answer : tmp;
            }
        }

        System.out.println(answer);
    }
}