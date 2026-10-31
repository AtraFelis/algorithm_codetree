import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final int MAX_NUM = 100_000;
    private static int[] uf = new int[MAX_NUM + 1];
    private static int[] size = new int[MAX_NUM + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i <= MAX_NUM; i++) {
            uf[i] = i;
            size[i] = 1;
        }
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a, b);
            sb.append(size[find(b)]).append('\n');
        }

        System.out.println(sb);
    }

    private static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB)
            return;

        if (size[rootA] < size[rootB]) {
            size[rootB] += size[rootA]; //
            uf[rootA] = rootB; // a의 root는 이제 b
        } else {
            size[rootA] += size[rootB];
            uf[rootB] = rootA;
        }
    }

    private static int find(int a) {
        if (uf[a] == a) {
            return a;
        }
        int root = find(uf[a]);
        uf[a] = root;
        return root;
    }
}
