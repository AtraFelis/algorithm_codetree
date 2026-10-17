import java.util.*;

class Bomb implements Comparable<Bomb> {
    
    int timeLimit, score;

    public Bomb(int score, int timeLimit) {
        this.score = score;
        this.timeLimit = timeLimit;
    }

    // @Override
    // public int compareTo(Bomb b) {
    //     if(this.score == b.score)
    //         return Integer.compare(this.timeLimit, b.timeLimit);
    //     return Integer.compare(b.score, this.score);
    // }

    // @Override
    // public int compareTo(Bomb b) {
    //     if(this.timeLimit == b.timeLimit)
    //         return Integer.compare(b.score, this.score);
    //     return Integer.compare(this.timeLimit, b.timeLimit);
    // }

    @Override
    public int compareTo(Bomb b) {
        return Double.compare((double)b.score / b.timeLimit, (double)this.score / this.timeLimit);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Bomb[] bombs = new Bomb[n];
        int lastLimit = 0;
        for (int i = 0; i < n; i++) {
            int score = sc.nextInt();
            int timeLimit = sc.nextInt();
            bombs[i]= new Bomb(score, timeLimit);
            lastLimit = Math.max(lastLimit, timeLimit);
        }

        Arrays.sort(bombs);
        // for(int i = 0; i < n; i++){
        //     System.out.printf("%d %d\n", bombs[i].score, bombs[i].timeLimit);
        // }

        int ans = 0;
        int curTime = 0;
        for(int i = 0; i < n; i++) {
            // System.out.printf("%d %d : %d\n", bombs[i].score, bombs[i].timeLimit, curTime);
            if(curTime < bombs[i].timeLimit) {
                ans += bombs[i].score;
                curTime++;
            }
        }

        System.out.println(ans);
    }
}