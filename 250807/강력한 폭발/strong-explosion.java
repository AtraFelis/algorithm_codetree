import java.util.*;

public class Main {

    private static int n;
    private static int[][] grid;
    private static List<int[]> pos = new ArrayList<>();

    private static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        grid = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();

                if(grid[i][j] == 1)
                    pos.add(new int[]{i, j});
            }
        }

        int[] batch = new int[pos.size()];
        backtracking(batch, 0);

        System.out.println(answer);
    }


    private static void backtracking(int[] batch, int depth) {
        if(depth == pos.size()) {
            boolean[][] map = new boolean[n][n];
            for(boolean[] line : map) 
                Arrays.fill(line, false);
            
            for(int i = 0; i < pos.size(); i++) {
                int[] curPos = pos.get(i);
                map[curPos[0]][curPos[1]] = true;

                if(batch[i] == 0) {
                    if(curPos[0] - 2 >= 0) map[curPos[0] - 2][curPos[1]] = true;
                    if(curPos[0] - 1 >= 0) map[curPos[0] - 1][curPos[1]] = true;
                    if(curPos[0] + 1 < n) map[curPos[0] + 1][curPos[1]] = true;
                    if(curPos[0] + 2 < n) map[curPos[0] + 2][curPos[1]] = true;
                } else if(batch[i] == 1) {
                    if(curPos[0] - 1 >= 0) map[curPos[0] - 1][curPos[1]] = true;
                    if(curPos[1] + 1 < n) map[curPos[0]][curPos[1] + 1] = true;
                    if(curPos[0] + 1 < n) map[curPos[0] + 1][curPos[1]] = true;
                    if(curPos[1] - 1 >= 0) map[curPos[0]][curPos[1] - 1] = true;
                } else {
                    if(curPos[0] - 1 >= 0 && curPos[1] - 1 >= 0) map[curPos[0] - 1][curPos[1] - 1] = true;
                    if(curPos[0] - 1 >= 0 && curPos[1] + 1 < n) map[curPos[0] - 1][curPos[1] + 1] = true;
                    if(curPos[0] + 1 < n && curPos[1] + 1 < n) map[curPos[0] + 1][curPos[1] + 1] = true;
                    if(curPos[0] + 1 < n && curPos[1] - 1 >= 0) map[curPos[0] + 1][curPos[1] - 1] = true;
                }
            }

            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(map[i][j]) cnt++;
                }
            }
            
            answer = Math.max(answer, cnt);
            return;
        }
        for(int i = 0; i < 3; i++) {
            batch[depth] = i;
            backtracking(batch, depth + 1);
        }
    }
}