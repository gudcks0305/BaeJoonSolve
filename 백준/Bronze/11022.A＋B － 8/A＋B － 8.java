import java.util.Scanner;

public class Main {

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int T  = sc.nextInt();
        for(int i=0; i<T ; i++){
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            int sum = n1 + n2;
            System.out.println("Case #" +(i+1)+ ": " + n1 +" + "+ n2+" = "+ sum);
        }







    }



}

