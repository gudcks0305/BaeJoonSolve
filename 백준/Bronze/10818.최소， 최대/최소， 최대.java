import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        int[] arr = new int[N];
        int max = -1000000,min = 1000000;
        for(int i = 0; i<arr.length; i++){
            arr[i] = in.nextInt();
            if(max<arr[i]) max = arr[i];
            if(min>arr[i]) min = arr[i];

        }
        System.out.print(min +" " +max);
        
        
    }
}