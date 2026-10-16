import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;


       TreeMap<Integer, Integer> map = new TreeMap<>();
    
        int n = Integer.parseInt(br.readLine());
        stk = new StringTokenizer(br.readLine());

        int last = 0;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(stk.nextToken());
            last += num;

            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int ans = 0;
        Map.Entry<Integer, Integer> entry;
        while(!(map.size() == 1 && map.get(map.firstKey()) == 1)) {
            int sum = 0;
            for(int i = 0; i < 2; i++) {
                entry = map.pollFirstEntry();
                sum += entry.getKey();
                if(entry.getValue() != 1) {
                    map.put(entry.getKey(), entry.getValue() - 1);
                }
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            ans += sum;
        }

        System.out.println(ans);
    }
}