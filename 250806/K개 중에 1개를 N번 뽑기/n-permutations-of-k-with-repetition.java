import java.util.*;

public class Main {

    private static List<Integer[]> pairs = new ArrayList<>();
    public static int[] pair;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();

        pair = new int[n];

        backtracking(k, n, 0);
        StringBuilder sb = new StringBuilder();
        for(Integer[] pair : pairs) {
            sb.append(pair[0]).append(" ").append(pair[1]).append('\n');
        }

        System.out.println(sb);
    }
    public static void backtracking(int k, int n, int depth) {
        if(depth == n) {
            pairs.add(new Integer[]{pair[0], pair[1]});
            return;
        }

        for(int i = 1; i <= k; i++) {
            pair[depth] = i;
            backtracking(k, n, depth+1);
        }
    }
}