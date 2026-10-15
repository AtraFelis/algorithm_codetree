import java.util.Scanner;
public class Main {

    public static final int MAX = 100 * 1000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n];
        char[] d = new char[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            d[i] = sc.next().charAt(0);
        }

        int pos = MAX;
        int[] tiles = new int[MAX * 2 + 1];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < x[i]; j++) {
                if(d[i] == 'L') {
                    tiles[pos--] = -1;
                } else {
                    tiles[pos++] = 1;
                }
            }
            if(d[i] == 'L') {
                pos++;
            } else {
                pos--;
            }
        }

        int w = 0, b = 0;
        for(int i = 0; i < tiles.length; i++) {
            if(tiles[i] == -1)
                w++;
            if(tiles[i] == 1)
                b++;
        }

        System.out.printf("%d %d", w, b);
    }
}