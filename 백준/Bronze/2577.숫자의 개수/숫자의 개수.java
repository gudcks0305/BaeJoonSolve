import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A,B,C;
        String result;
        int[] num = new int[10];
        for(int i=0; i< num.length;i++){
            num[i]=0;
        }
        A = sc.nextInt();
        B = sc.nextInt();
        C = sc.nextInt();
        result = String.valueOf(A*B*C);
        for(int k=0; k<result.length();k++){
            if(result.charAt(k) == '0') num[0]++;
            else if(result.charAt(k) == '1') num[1]++;
            else if(result.charAt(k) == '2') num[2]++;
            else if(result.charAt(k) == '3') num[3]++;
            else if(result.charAt(k) == '4') num[4]++;
            else if(result.charAt(k) == '5') num[5]++;
            else if(result.charAt(k) == '6') num[6]++;
            else if(result.charAt(k) == '7') num[7]++;
            else if(result.charAt(k) == '8') num[8]++;
            else num[9]++;
        }
        for(int i=0; i< num.length;i++){
            System.out.println(num[i]);
        }



    }
}