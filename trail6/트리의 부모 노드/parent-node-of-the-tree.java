import java.util.*;
import java.io.*;

public class Main {
    private static int[] parents;
    private static List<List<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());


        graph = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        parents = new int[n + 1];

        dfs(1);

        for(int i = 2; i <= n; i++) {
            sb.append(parents[i]).append('\n');
        }
        System.out.println(sb);
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