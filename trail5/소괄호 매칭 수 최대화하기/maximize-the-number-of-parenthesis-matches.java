import java.util.*;
import java.io.*;

public class Main {

    public static class Paren implements Comparable<Paren> {
        
        String t;
        double ratio;
        
        public Paren(String t) {
            this.t = t;
        }

        @Override
        public int compareTo(Paren p) {
            return Double.compare(p.ratio, ratio);
        }

        @Override
        public String toString() {
            return t + " " + ratio;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Paren[] parens = new Paren[n];
        for(int i = 0; i < n; i++) {
            parens[i] = new Paren(br.readLine());
            char[] chars = parens[i].t.toCharArray();

            int open = 0, close = 0;
            for(char c : chars) {
                if(c == '(') open++;
                else close++;
            }

            if(open == 0) parens[i].ratio = 0;
            else if(close == 0) parens[i].ratio = Double.MAX_VALUE;
            else {
                parens[i].ratio = (double)open / close;
            }
        }

        Arrays.sort(parens);
        // System.out.println(Arrays.toString(parens));

        String t = "";
        for(Paren p : parens) {
            t += p.t;
        }
        // System.out.println(t);

        int ans = 0;
        char[] tArr = t.toCharArray();
        for(int i = 0; i < tArr.length; i++) {
            if(tArr[i] == ')')
                continue;
            for(int j = i; j < tArr.length; j++) {
                if(tArr[j] == ')') {
                    ans++;
                }
            }
        }

        // int[] scores = new int[n];
        // for(int i = tArr.length - 1; i >= 0 ; i--) {
            
        // }

        System.out.println(ans);
    }
}