import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        Map<String, String> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            String command = stk.nextToken();

            if(command.equals("add")){
                String key = stk.nextToken();
                String value = stk.nextToken();
                map.put(key, value);
            }
            else if(command.equals("remove")){
                String key = stk.nextToken();
                map.remove(key);
            }
            else {
                String key = stk.nextToken();
                sb.append(map.getOrDefault(key, "None")).append('\n');
            }
        }

        System.out.println(sb);
    }
}