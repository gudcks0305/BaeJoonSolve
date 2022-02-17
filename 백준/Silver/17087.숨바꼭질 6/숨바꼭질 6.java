import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);

        int n =sc.nextInt(); //동생의 수
        int s = sc.nextInt(); //나의 위치
        int [] arr = new int[n];

        for(int i=0; i<n; i++) {
            int a = sc.nextInt(); //동생의 위치
            arr[i] = Math.abs(s-a); // 내위치와 동생의 위치 차이 저장
        }

        int gcd = arr[0];
        for(int i=1; i<arr.length; i++) {
            gcd = GCD(gcd,arr[i]);
        }
        System.out.println(gcd);
    }
    static int GCD(int a, int b){
        if(b==0) return a;
        else {
            return GCD(b , a%b);
        }
    }

}