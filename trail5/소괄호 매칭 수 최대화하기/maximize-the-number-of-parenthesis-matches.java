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

        List<Character> tList = new ArrayList<>();
        for(Paren p : parens) {
            for(char c : p.t.toCharArray()) {
                tList.add(c);
            }
        }
        // System.out.println(t);

        long ans = 0;
        // for(int i = 0; i < tList.size(); i++) {
        //     if(tList.get(i) == ')')
        //         continue;
        //     for(int j = i; j < tList.size(); j++) {
        //         if(tList.get(j) == ')') {
        //             ans++;
        //         }
        //     }
        // }

        int[] scores = new int[tList.size()];
        int score = 1;
        for(int i = tList.size() - 1; i >= 0 ; i--) {
            if(tList.get(i) == ')') {
                scores[i] = score++;
            }
        }

        // System.out.println(tList);
        // System.out.println(Arrays.toString(scores));

        for(int i = 0; i < tList.size(); i++) {
            if(tList.get(i) == '(') {
                for(int j = i; j < tList.size(); j++) {
                    if(scores[j] != 0) {
                        ans += scores[j];
                        break;
                    }
                }
            }
        }

        System.out.println(ans);
    }
}