import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        int i = 0;
        int R;
        String S;
        while (i<T){
            String result = "";
            R = in.nextInt();
            S = in.next();
            for(int k =0; k<S.length(); k++) {
               for(int j=0;j<R;j++) {
                   result += S.charAt(k);
                }

            }
            System.out.println(result);
            i++;

        }

    }
}