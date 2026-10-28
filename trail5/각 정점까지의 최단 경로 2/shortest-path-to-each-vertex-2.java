import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] dist = new int[n + 1][n + 1];
        for (int i = 0; i < dist.length; i++) {
            Arrays.fill(dist[i], (int) 1e9);
            dist[i][i] = 0;
        }

        for (int idx = 1; idx <= m; idx++) {
            st = new StringTokenizer(br.readLine());

            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            dist[i][j] = Math.min(dist[i][j], w);
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < dist.length; i++) {
            for (int j = 1; j < dist.length; j++) {
                int value = dist[i][j] != (int) 1e9 ? dist[i][j] : -1;
                sb.append(value).append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}
