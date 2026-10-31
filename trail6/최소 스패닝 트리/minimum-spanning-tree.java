import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main {

    private static int[] uf;
    private static int[] size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] edges = new int[m][3];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            edges[i][0] = Integer.parseInt(st.nextToken());
            edges[i][1] = Integer.parseInt(st.nextToken());
            edges[i][2] = Integer.parseInt(st.nextToken());
        }

        uf = new int[n + 1];
        size = new int[n + 1];
        for(int i = 0; i <= n; i++) {
            uf[i] = i;
            size[i] = 1;
        }

        Arrays.sort(edges, (e1, e2) -> Integer.compare(e1[2], e2[2]));
        int ans = 0;
        int selected = 0;
        for (int i = 0; i < m; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            if(find(a) == find(b))
                continue;
            union(a, b);
            ans += edges[i][2];

            if(++selected == n - 1)
                break;
        }

        System.out.println(ans);
    }

    private static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if(size[rootA] > size[rootB]) {
            uf[rootA] = rootB;
            size[rootB] += size[rootA];
        } else {
            uf[rootB] = rootA;
            size[rootA] += size[rootB];
        }
    }

    private static int find(int a) {
        if(uf[a] == a) {
            return a;
        }
        int root = find(uf[a]);
        uf[a] = root;
        return root;
    }
}
