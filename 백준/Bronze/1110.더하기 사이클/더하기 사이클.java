import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int num,num2,num3 = 0;
        int cnt=0;
        int numL;
        int numR;
        num =sc.nextInt();
        num3= num;
        while(true){
            numL = num%10;
            numR = (numL + num/10) % 10;
            num = numL * 10 + numR;
            cnt++;
            if(num3==num){
                System.out.print(cnt);
                break;
            }
        }






    }
}
