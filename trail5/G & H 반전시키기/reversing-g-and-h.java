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

        int idx = 0;
        int ans = 0;
        boolean flag = true; // true : 이전 문자도 동일했음 false : 이전 문자 동일하지 않음
        while (idx != a.length()) {
            if (aChars[idx] == bChars[idx] && flag == false) {
                ans++;
                flag = true;
            } else if (aChars[idx] != bChars[idx]) {
                flag = false;
            }

            idx++;
        }

        System.out.println(ans);
    }
}