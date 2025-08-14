import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Map<Integer, Integer> map = new TreeMap<>();

        int n = Integer.parseInt(br.readLine());        
        for(int i = 0; i < n; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            String command = stk.nextToken();
            if(command.equals("add")) {
                int key = Integer.parseInt(stk.nextToken());
                int value = Integer.parseInt(stk.nextToken());
                map.put(key, value);
            }
            else if(command.equals("remove")) {
                int key = Integer.parseInt(stk.nextToken());
                map.remove(key);
            }
            else if(command.equals("find")) {
                int key = Integer.parseInt(stk.nextToken());
                sb.append(map.containsKey(key) ? map.get(key) : "None").append('\n');
            }
            else {
                if(map.isEmpty()) {
                    sb.append("None\n");
                }
                else {
                    map.forEach((key, value) -> sb.append(value).append(" "));
                    sb.append('\n');
                }
            }
        }

        System.out.println(sb);
    }
}