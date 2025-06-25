import java.util.Scanner;

public class Main {
    private static int n, m;
    private static int[][] grid;
    private static int maxSum = 0;
    
    // L자 블록의 4가지 회전 형태 (기준점에서 상대적 위치)
    private static final int[][][] L_SHAPES = {
        {{0, 0}, {1, 0}, {0, 1}}, // ㄱ 모양
        {{0, 0}, {0, 1}, {-1, 1}}, // ㄴ 모양  
        {{0, 0}, {-1, 0}, {0, -1}}, // ㄱ 뒤집은 모양
        {{0, 0}, {0, -1}, {1, -1}}  // ㄴ 뒤집은 모양
    };
    
    // 일자 블록의 2가지 형태
    private static final int[][][] I_SHAPES = {
        {{0, 0}, {0, 1}, {0, 2}}, // 가로
        {{0, 0}, {1, 0}, {2, 0}}  // 세로
    };
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        
        grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        
        // 모든 위치에서 모든 블록 형태 시도
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // L자 블록들 시도
                for (int[][] shape : L_SHAPES) {
                    if (canPlaceBlock(i, j, shape)) {
                        int sum = getBlockSum(i, j, shape);
                        maxSum = Math.max(maxSum, sum);
                    }
                }
                
                // 일자 블록들 시도
                for (int[][] shape : I_SHAPES) {
                    if (canPlaceBlock(i, j, shape)) {
                        int sum = getBlockSum(i, j, shape);
                        maxSum = Math.max(maxSum, sum);
                    }
                }
            }
        }
        
        System.out.println(maxSum);
        sc.close();
    }
    
    /**
     * 블록 내 숫자들의 합 구하기
     * @param baseRow 블록의 기준 행
     * @param baseCol 블록의 기준 열
     * @param shape 블록의 형태
     * @return 블록 내 숫자들의 합
     */
    private static int getBlockSum(int baseRow, int baseCol, int[][] shape) {
        int sum = 0;
        for (int[] offset : shape) {
            int row = baseRow + offset[0];
            int col = baseCol + offset[1];
            sum += grid[row][col];
        }
        return sum;
    }
    
    /**
     * 특정 위치에 블록을 놓을 수 있는지 확인
     * @param baseRow 블록의 기준 행
     * @param baseCol 블록의 기준 열
     * @param shape 블록의 형태
     * @return 배치 가능 여부
     */
    private static boolean canPlaceBlock(int baseRow, int baseCol, int[][] shape) {
        for (int[] offset : shape) {
            int newRow = baseRow + offset[0];
            int newCol = baseCol + offset[1];
            
            // 격자 범위를 벗어나면 불가능
            if (!isValid(newRow, newCol)) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * 좌표가 유효한 범위 내에 있는지 확인
     * @param row 행
     * @param col 열
     * @return 유효성 여부
     */
    private static boolean isValid(int row, int col) {
        return row >= 0 && row < n && col >= 0 && col < m;
    }
}