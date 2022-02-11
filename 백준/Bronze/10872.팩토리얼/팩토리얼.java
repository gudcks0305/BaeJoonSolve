import java.util.Scanner;

public class Main {

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        sum = pac(n);
        System.out.println(sum);
    }
    public static int pac(int n){
       if(n<=1) return 1;
       return n * pac(n-1);
    }

}

