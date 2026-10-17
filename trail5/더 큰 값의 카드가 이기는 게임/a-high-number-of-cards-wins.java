import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[] aCards = new int[n], bCards = new int[n];        
        boolean[] cards = new boolean[n * 2 + 1];
        for (int i = 0; i < n; i++) {
            bCards[i] = Integer.parseInt(br.readLine());
            cards[bCards[i]] = true;
        }

        int idx = 0;
        for(int i = 1; i < cards.length; i++) {
            if(!cards[i])
                aCards[idx++] = i;
        }

        Arrays.sort(aCards);
        Arrays.sort(bCards);

        // System.out.println(Arrays.toString(aCards));
        // System.out.println(Arrays.toString(bCards));

        int ans = 0;
        int bIdx = 0;
        for(int aIdx = 0; aIdx < n; aIdx++) {
            if(bIdx < n && bCards[bIdx] < aCards[aIdx]) {
                ans++;
                bIdx++;
            }
        }

        System.out.println(ans);
    }
}
