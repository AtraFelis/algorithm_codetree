import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n];
        char[] dir = new char[n];
        int min = 0, max = 0;

        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            dir[i] = sc.next().charAt(0);
            if(dir[i] == 'L') min += x[i];
            else max += x[i];
        }


        int[][] tiles = new int[min + max + 1][3];

        int pos = min-1;

        // 현재색 [][0] 흰색을 칠한 횟수 [][1] 검정색을 칠한 횟수 [][2]
        // 흰색 1, 검정색 2 회색 3
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < x[i]; j++) {
                if(dir[i] == 'L') {
                    tiles[pos][0] = 1;
                    tiles[pos][1]++;
                    if(tiles[pos][1] >= 2 && tiles[pos][2] >= 2)
                        tiles[pos][0] = 3;
                    pos--;
                } else {
                    tiles[pos][0] = 2;
                    tiles[pos][2]++;
                    if(tiles[pos][1] >= 2 && tiles[pos][2] >= 2)
                        tiles[pos][0] = 3;
                    pos++;
                }
            }

            if(dir[i] == 'L') pos++;
            else pos--;


            // for(int j = 0; j < tiles.length; j++) {
            //     System.out.printf("%d ", tiles[j][0]);
            // }
            // System.out.println();
        }

        int w = 0, g = 0, b = 0;
        for(int i  = 0; i < tiles.length; i++) {
            if(tiles[i][0] == 1) w++;
            else if(tiles[i][0] == 2) b++;
            else if(tiles[i][0] == 3) g++;

        }

        System.out.printf("%d %d %d", w, b, g);
    }
}