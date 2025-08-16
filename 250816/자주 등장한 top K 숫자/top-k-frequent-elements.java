import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Map<Integer, Integer> map = new HashMap<>();

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int key = Integer.parseInt(stk.nextToken());
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> sortedEntries = new ArrayList<>(map.entrySet());
        sortedEntries.sort((e1, e2) -> {
            if(e1.getValue() == e2.getValue())
                return e2.getKey() - e1.getKey();
            return e2.getValue() - e1.getValue();
        });

        for(int i = 0; i < k; i++) {
            sb.append(sortedEntries.get(i).getKey()).append(" ");
        }
        System.out.println(sb);
    }
}