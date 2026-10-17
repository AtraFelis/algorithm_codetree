import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] cards = new int[n * 2 + 1];
        for (int i = 0; i < n; i++) {
            cards[sc.nextInt()] = 1; // B의 카드는 1
        }


        boolean[] visited = new boolean[n * 2 + 1];
        visited[0] = true;
        cards[0] = -1;
        int ans = 0;

        for (int i = 1; i < cards.length; i++) {
            if(!visited[i] && cards[i] == 1) {
                visited[i] = true;
                for(int j = i+1; j < cards.length; j++) {
                    if(j >= cards.length)
                        j = 1;

                    if(cards[j] == 0 && !visited[j]) {
                        ans += i < j ? 1 : 0;
                        visited[j] = true;
                        break;
                    }
                }
            }
        }

        System.out.println(ans);
    }
}
