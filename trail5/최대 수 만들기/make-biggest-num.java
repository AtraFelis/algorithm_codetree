import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        Arrays.sort(arr, (a, b) -> {
            long ab = Long.parseLong("" + a + b); // a 뒤에 b를 붙인 값
            long ba = Long.parseLong("" + b + a); // b 뒤에 a를 붙인 값
            return Long.compare(ba, ab);
        });

        StringBuilder sb = new StringBuilder();
        for (int num : arr) {
            sb.append(num);
        }
        System.out.println(sb);
    }
}