import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken()); // 빨간 돌 개수
        int n = Integer.parseInt(st.nextToken()); // 검정 돌 개수

        // 빨간 돌의 T 값 입력 후 오름차순 정렬
        int[] reds = new int[c];
        for (int i = 0; i < c; i++) {
            reds[i] = Integer.parseInt(br.readLine().trim());
        }
        Arrays.sort(reds);

        // 검정 돌의 [A, B] 구간 입력 후 A 기준 오름차순 정렬
        int[][] blacks = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            blacks[i][0] = Integer.parseInt(st.nextToken());
            blacks[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(blacks, (x, y) -> Integer.compare(x[0], y[0]));

        // 현재 사용 가능한 구간들의 B 값을 최소 힙으로 관리
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int idx = 0;   // 검정 돌 포인터
        int count = 0; // 매칭된 쌍의 수

        for (int t : reds) {
            // A <= T인 구간을 모두 힙에 추가 (B 값만 저장)
            while (idx < n && blacks[idx][0] <= t) {
                pq.offer(blacks[idx][1]);
                idx++;
            }

            // 이미 끝나버린 구간(B < T) 제거
            while (!pq.isEmpty() && pq.peek() < t) {
                pq.poll();
            }

            // 가장 빨리 끝나는 구간과 매칭
            if (!pq.isEmpty()) {
                pq.poll();
                count++;
            }
        }

        System.out.println(count);
    }
}