import java.util.*;
import java.io.*;

public class Main {

    private static int answer = 10001;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        int[] arr = new int[n];
        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        visited = new boolean[n];
        
        backtracking(arr, m, 0);
        System.out.println(answer == 10001 ? - 1 : answer);
    }

    private static int sum = 0;
    private static void backtracking(int[] arr, int m, int depth) {
        if(sum == m) {
            answer = Math.min(answer, depth);

            return;
        } else if (sum > m) {
            return;
        }

        for(int i = depth; i < arr.length; i++) {
            if(visited[i]) continue;

            sum += arr[i];
            visited[i] = true;
            backtracking(arr, m, depth + 1);
            visited[i] = false;
            sum -= arr[i];
        }
    }
}