import java.util.*;
import java.io.*;

public class Main {
    public static class Meeting implements Comparable<Meeting> {
        int start, end;

        public Meeting(int s, int e) {
            start = s;
            end = e;
        }
        
        @Override
        public int compareTo(Meeting m) {
            if(end == m.end)
                return Integer.compare(start, m.start);
            return Integer.compare(end, m.end);
        }
    }

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        int n = Integer.parseInt(br.readLine());
        Meeting[] meetings = new Meeting[n];
        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(stk.nextToken());
            int e = Integer.parseInt(stk.nextToken());
            meetings[i] = new Meeting(s, e);
        }

        Arrays.sort(meetings);

        int ans = meetings.length;
        int curTime = 0;
        for(int i = 0; i < n; i++) {
            if(meetings[i].start >= curTime) {
                ans--;
                curTime = meetings[i].end;
            }
        }

        System.out.println(ans);
    }
}