import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static int[] arr;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 서로 겹치지 않는다면, &연산 했을 때 0이 되어야 함

        dfs(0, 0 ,0 ,0);

        System.out.println(ans);
    }

    private static long ans = 0;

    private static void dfs(int idx, int sum, int size, int mask) {
        if (size == 3) {
            ans = Math.max(sum, ans);
            return;
        }

        for (int i = idx; i < n; i++) {
            if ((arr[i] & mask) != 0) {
                continue;
            }
            dfs(i + 1, sum + arr[i], size + 1, mask | arr[i]);
        }
    }
}