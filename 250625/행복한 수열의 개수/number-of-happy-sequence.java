import java.util.Scanner;
  
public class Main {
    public static int ans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        
        ans = 0;
        checkRow(grid, m);
        checkCol(grid, m);

        
        if(n==1) ans = 2;
        System.out.println(ans);
    }

    private static void checkRow(int[][] grid, int m) {
        int len = grid.length;
        for(int i=0; i<len; i++) {
            int check = 1;    
            for(int j=1; j<len; j++) {
                if(grid[i][j-1]==grid[i][j]) check++;
                else check = 1;

                if(check >= m) {
                    ans++;
                    break;
                }
            }
        }
    }

    private static void checkCol(int[][] grid, int m) {
        int len = grid.length;
        for(int i=0; i<len; i++) {
            int check = 1;    
            for(int j=1; j<len; j++) {
                if(grid[j-1][i]==grid[j][i]) check++;
                else check = 1;

                if(check >= m) {
                    ans++;
                    break;
                }
            }
        }
    }
}