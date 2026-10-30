import java.util.*;

public class Main {
    private static int[] parents;
    private static List<List<Integer>> graph;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        graph = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < n - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        parents = new int[n + 1];

        dfs(1);

        for(int i = 2; i <= n; i++) {
            System.out.println(parents[i]);
        }
    }

    private static void dfs(int parent) {
        for(Integer child : graph.get(parent)) {
            if(parents[parent] == child)
                continue;
            parents[child] = parent;

            dfs(child);
        }
    }
}