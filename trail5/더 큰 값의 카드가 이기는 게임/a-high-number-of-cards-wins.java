import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int[] bCards = new int[n], aCards = new int[n];
        for (int i = 0; i < n; i++) {
            bCards[i] = sc.nextInt();
        }
        
        Arrays.sort(bCards);

        int ans = 0;
        for(int i = 1; i < n; i++) {
            if(bCards[i - 1] - bCards[i] != 1)
                ans++;
        }

        System.out.println(ans);
    }
}