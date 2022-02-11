import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int N=0;
        int cnt=0;
        N = sc.nextInt();
        ArrayList<Integer> num = new ArrayList<>();
        for(int i=0; i<N; i++){
            num.add(sc.nextInt());
        }
        for(int i=0; i<N; i++){
            int C = 0;
            if(num.get(i) == 1 ) C++;
            for(int j = 2 ; j< num.get(i); j++){

                if(num.get(i) % j == 0 ) {
                    C++;
                }
            }
            if(C == 0) cnt ++;

        }
        System.out.println(cnt);
    }
}
