import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int sum= 0;
        int n= sc.nextInt();
        String num = sc.next();
        for(int i = 0; i<n;i++){
            sum = sum +Integer.parseInt(String.valueOf(num.charAt(i)));

        }
        System.out.print(sum);

    }
}
