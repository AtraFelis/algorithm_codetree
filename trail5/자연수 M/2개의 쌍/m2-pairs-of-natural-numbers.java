import java.util.*;

class Pair implements Comparable<Pair>{
    int num, count;

    public Pair(int count, int num) {
        this.num = num;
        this.count = count;
    }

    @Override
    public int compareTo(Pair p) {
        return this.num - p.num;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = 0;
        Pair[] pairs = new Pair[n];

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            m += y;
            pairs[i] = new Pair(x, y);
        }

        Arrays.sort(pairs);

        // for (int i = 0; i < n; i++) {
        //     System.out.printf("%d %d\n", pairs[i].num, pairs[i].count);
        // }
        // System.out.println();

        int ans = 0;
        int first = 0, last = n - 1;
        while(first != last) {
            ans = Math.max(ans, pairs[first].num + pairs[last].num);
            
            // System.out.print(pairs[first].count - pairs[last].count + "|");
            // System.out.printf(" %d %d | %d %d | %d\n", pairs[first].count, pairs[first].num, pairs[last].num, pairs[last].count, ans);

            if(pairs[first].count < pairs[last].count) {
                pairs[last].count -= pairs[first].count;
                first++;
            } else if(pairs[first].count > pairs[last].count) {
                pairs[first].count -= pairs[last].count;
                last--;
            } else {
                pairs[first].count = 0;
                pairs[last].count = 0;
                last--;
                first++;
            }

        }

        ans = Math.max(ans, pairs[first].num + pairs[last].num);

        System.out.println(ans);
    }
}