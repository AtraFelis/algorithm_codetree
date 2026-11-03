import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // 서로 겹치지 않는다면, &연산 했을 때 0이 되어야 함
        Map<Integer, List<Integer>> map = new HashMap<>();
        map.put(arr[0], new ArrayList<>());
        map.get(arr[0]).add(arr[0]);
        for (int i = 1; i < n; i++) {
            boolean flag = false;
            for (Integer num : map.keySet()) {
                if ((num & arr[i]) == 0) {
                    map.get(num).add(arr[i]);
                    flag = true;
                    break;
                }
            }
            if (flag) {
                map.put(arr[i], new ArrayList<>());
                map.get(arr[i]).add(arr[i]);
            }
        }

        long ans = 0;
        for (Integer num : map.keySet()) {
            List<Integer> list = map.get(num);

            if (list.size() < 3)
                continue;

            Collections.sort(list, Collections.reverseOrder());
            long sum = 0;
            for (int i = 0; i < 3; i++) {
                sum += (long) list.get(i);
            }
            ans = Math.max(ans, sum);
        }

        System.out.println(ans);
    }
}