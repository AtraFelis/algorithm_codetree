import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] nodes = new int[n-1][2];
        for (int i = 0; i < n - 1; i++) {
            nodes[i][0] = sc.nextInt(); // 부모
            nodes[i][1] = sc.nextInt(); // 자식
        }

        Arrays.sort(nodes, (n1, n2) -> Integer.compare(n1[1], n2[1]));

        for (int i = 0; i < n - 1; i++) {
            System.out.println(nodes[i][0]);
        }
    }
}