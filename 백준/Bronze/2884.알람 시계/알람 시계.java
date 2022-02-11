import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int H, M = 0;
        H = sc.nextInt();
        M = sc.nextInt();
        if(M>=45){
            M=M-45;
        }
        else{
            H--;
            M= M+15;
            if(H<0){
                H=23;
            }
        }
        System.out.println(H +" "+ M);
    }

}
