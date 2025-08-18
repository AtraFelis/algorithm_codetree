import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String p = sc.next();
        
        int[][] dp = new int[p.length()][s.length()];

        boolean flag = false;
        for(int i = 0; i < p.length(); i++) {
            for(int j = 0; j < s.length(); j++) {
                if(i + j >= p.length()) break;

                if(p.charAt(i + j) == s.charAt(j) || p.charAt(i + j) == '.') {
                    if(j == 0)
                        dp[i][j] = 1;
                    else
                        dp[i][j] = dp[i][j-1] + 1;
                }
                else if(p.charAt(i + j) == '*') {
                    char c = p.charAt(i + j - 1);
                    while(j < s.length() && (c == s.charAt(j) || c == '.')) {
                        if(j == 0)
                            dp[i][j] = 1;
                        else
                            dp[i][j] = dp[i][j-1] + 1;
                        j++;
                    }
                    j--;

                } else { // 패턴과 일치하지 않을 경우
                    dp[i][j] = 0;
                    break;
                }

                if(dp[i][j] == s.length()) flag = true;
            }
            if(flag) break;
        }

        System.out.println(flag ? "true" : "false");
        sc.close();
    }
}