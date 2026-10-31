import java.util.Scanner;
import java.util.Arrays;
public class Main {

    private static int[] uf;
    private static int[] size;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] edges = new int[m][3];
        for (int i = 0; i < m; i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
            edges[i][2] = sc.nextInt();
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

        if (rootA == rootB) return;

        if(size[rootA] > size[rootB]) {
            uf[rootB] = rootA;
            size[rootA] += size[rootB];
        } else {
            uf[rootA] = rootB;
            size[rootB] += size[rootA];
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