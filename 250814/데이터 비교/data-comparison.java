import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());

        HashSet<Integer> set = new HashSet<>();
        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            set.add(Integer.parseInt(stk.nextToken()));
        }

        stk = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            sb.append(set.contains(Integer.parseInt(stk.nextToken())) ? "1 " : "0 ");
        }

        System.out.println(sb);
    }
}