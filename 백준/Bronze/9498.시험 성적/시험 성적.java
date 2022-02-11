import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int num=0;
        String cal;
        num = sc.nextInt();


        if(num>=90 && num<=100){
            cal = "A";
        }
        else if(num>=80  && num<=89){
            cal = "B";
        }
        else if(num>=70 && num<=79){
            cal = "C";
        }

        else if(num>=60 && num<=69){
            cal = "D";
        }
        else{
            cal = "F";
        }
        System.out.println(cal);

    }


}
