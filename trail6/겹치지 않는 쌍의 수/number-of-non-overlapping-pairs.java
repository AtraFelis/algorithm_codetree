import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] group = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());

            for (int j = 0; j < m; j++) {
                int c = Integer.parseInt(st.nextToken());
                group[i] = group[i] ^ (1 << c);
            }
        }

        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((group[i] & group[j]) == 0) {
                    ans++;
                }
            }
        }

        System.out.println(ans);
    }
}
