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

        int ans = 0;
        int curTime = 0;
        for(int i = 0; i < n; i++) {            
            if(curTime < bombs[i].timeLimit) {
                ans += bombs[i].score;
                curTime++;
            }
        }

        System.out.println(ans);
    }
}