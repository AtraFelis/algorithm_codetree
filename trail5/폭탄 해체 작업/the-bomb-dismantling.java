import java.util.*;

class Bomb implements Comparable<Bomb> {
    
    int timeLimit, score;

    public Bomb(int score, int timeLimit) {
        this.score = score;
        this.timeLimit = timeLimit;
    }

    @Override
    public int compareTo(Bomb b) {
        if(this.timeLimit == b.timeLimit)
            return Integer.compare(b.score, this.score);
        return Integer.compare(this.timeLimit, b.timeLimit);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Bomb[] bombs = new Bomb[n];
        for (int i = 0; i < n; i++) {
            int score = sc.nextInt();
            int timeLimit = sc.nextInt();
            bombs[i]= new Bomb(score, timeLimit);
        }

        Arrays.sort(bombs);
        // for(int i = 0; i < n; i++){
        //     System.out.printf("%d %d\n", bombs[i].score, bombs[i].timeLimit);
        // }

        int ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < n; i++) {
            // System.out.printf("%d %d\n", bombs[i].score, bombs[i].timeLimit);

            int score = bombs[i].score;
            int timeLimit = bombs[i].timeLimit;

            pq.add(score);
            if(pq.size() > timeLimit) {
                pq.remove();
            }    
        }

        for(Integer score : pq) {
            ans += score;
        }

        System.out.println(ans);
    }
}