import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    private static final int MAX_NUM = 100_000;
    private static int[] uf = new int[MAX_NUM + 1];
    private static Set<Integer> idxSet = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i <= MAX_NUM; i++) {
            uf[i] = i;
        }
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            idxSet.add(a);
            idxSet.add(b);
            union(a, b);

            int cnt = 0;
            for (Integer idx : idxSet) {
                find(idx);
                if (uf[idx] == b) {
                    cnt++;
                }
            }

            System.out.println(cnt);
        }
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        uf[a] = b;
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
