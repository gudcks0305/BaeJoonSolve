import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a,b,c;
        a = in.nextInt();
        b = in.nextInt();
        c = in.nextInt();
        int cnt =  0;
        if(b>=c) {
            cnt = -1;

        }
        else cnt = a/(c-b) + 1;



        System.out.println(cnt);

    }
}