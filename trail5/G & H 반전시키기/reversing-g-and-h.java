import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String a = sc.next();
        String b = sc.next();
        // Please write your code here.

        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();

        int aIdx = 0, bIdx = 0;
        int ans = 0;
        while (aIdx != a.length() || bIdx != b.length()) {
            if (aChars[aIdx] == bChars[bIdx]) {
                if (aIdx != bIdx)
                    ans++;
                aIdx = ++bIdx;
            } else {
                bIdx++;
            }
        }

        System.out.println(ans);
    }
}