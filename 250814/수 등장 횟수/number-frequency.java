import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        
        Map<String, Integer> map = new HashMap<>();
        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            String k = stk.nextToken();
            map.put(k, map.getOrDefault(k, 0) + 1);
        }

        stk = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            sb.append(map.getOrDefault(stk.nextToken(), 0)).append(" ");
        }

        System.out.println(sb);
    }
}