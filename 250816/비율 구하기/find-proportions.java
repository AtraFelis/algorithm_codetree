import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> map = new TreeMap<>();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String key = br.readLine();
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        map.forEach((key, value) -> {
            sb.append(key).append(" ");
            float p = (float)value / n * 100;
            sb.append(String.format("%.4f", p)).append("\n");
        });

        System.out.println(sb);
    }
}