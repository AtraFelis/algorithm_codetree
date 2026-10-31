import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int n, m;
    private static int[] uf;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        uf = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            uf[i] = i;
        }
        // System.out.println(Arrays.toString(uf));

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            switch (cmd) {
                case 0:
                    union(a, b);
                    break;
                case 1:
                    if (find(a) == find(b)) {
                        System.out.println(1);
                    } else {
                        System.out.println(0);
                    }
                    break;
            }
        }
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        uf[a] = b;
    }

    private static int find(int a) {
        if (uf[a] == a)
            return a;
        int root = find(uf[a]);
        uf[a] = root;
        return root;
    }

}
