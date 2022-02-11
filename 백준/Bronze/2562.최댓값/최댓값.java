import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] score = new int[9];
        int num = 0;
        int max = -1000000;
        for(int i = 0; i<score.length; i++){
            score[i] = in.nextInt();
            if(max<score[i]){
                max = score[i];
                num = i+1;
            }
        }
        System.out.println(max);
        System.out.println(num);
        
    }
}