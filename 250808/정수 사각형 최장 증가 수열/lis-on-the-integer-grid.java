import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        int n = Integer.parseInt(br.readLine());
        int[][] grid = new int[n][n];
        
        List<int[]> pos = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(stk.nextToken());
                pos.add(new int[]{grid[i][j], i, j});
            }
        }

        Collections.sort(pos, (p1, p2) -> {
            return p1[0] - p2[0];
        });
        
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++)
            Arrays.fill(dp[i], 1);

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        for(int i = 0; i < pos.size(); i++) {
            int[] p = pos.get(i);
            int x = p[1], y = p[2];
            for(int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if(nx < 0 || ny < 0 || nx >= n || ny >= n)
                    continue;

                if(grid[x][y] < grid[nx][ny]) {
                    dp[nx][ny] = Math.max(dp[x][y] + 1, dp[nx][ny]);
                }
            }
        }

        int answer = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                answer = Math.max(answer, dp[i][j]);
            }
        }

        System.out.println(answer);
    }
}