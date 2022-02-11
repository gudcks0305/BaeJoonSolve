import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int num1;
        int num2;
        while(true){
           num1 = sc.nextInt();
           num2 = sc.nextInt();
           if(num1 ==0 & num2 ==0){
               System.out.print("\n");
               break;
           }

           System.out.println(num1+num2);
        }





    }
}
