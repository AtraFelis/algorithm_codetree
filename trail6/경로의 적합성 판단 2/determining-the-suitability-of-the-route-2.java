import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[] uf;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        uf = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            uf[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            union(x, y);
        }

        st = new StringTokenizer(br.readLine());

        boolean canGo = true;
        int root = find(Integer.parseInt(st.nextToken()));
        for (int i = 1; i < k; i++) {
            if (root != find(Integer.parseInt(st.nextToken()))) {
                canGo = false;
                break;
            }
        }

        System.out.println(canGo ? 1 : 0);
    }

    private static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        uf[rootX] = rootY;
    }

    private static int find(int y) {
        if (uf[y] == y)
            return y;

        int root = find(uf[y]);
        uf[y] = root;
        return root;
    }
}
