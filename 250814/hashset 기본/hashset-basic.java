import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        HashSet<String> set = new HashSet<>();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            String command = stk.nextToken();
            String value = stk.nextToken();
            
            if(command.equals("add"))
                set.add(value);
            else if(command.equals("remove"))
                set.remove(value);
            else {
                sb.append(set.contains(value) ? "true\n" : "false\n");
            }
        }

        System.out.println(sb);
    }
}