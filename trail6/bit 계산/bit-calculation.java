import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        int set = 0;
        for(int i = 0; i < q; i++) {
            String cmd = sc.next();

            int x = 0;
            if(!cmd.equals("clear"))
                x = sc.nextInt();

            if(cmd.equals("add")) {
                set = set | (1 << x);
            } else if(cmd.equals("delete")) {
                set = set & ~(1 << x);
            } else if(cmd.equals("print")) {
                System.out.println((set & (1 << x)) != 0 ? 1 : 0);
            } else if(cmd.equals("toggle")) {
                set = set ^ (1 << x);
            } else if(cmd.equals("clear")) {
                set = 0;
            }
        }
    }
}