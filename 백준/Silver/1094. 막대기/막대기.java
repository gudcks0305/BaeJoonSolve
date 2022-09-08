import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int sum = 64;
        int current = 64;
        int cnt = 0;
        while (sum >= n){
            if(sum == n){
                cnt++;
                break;
            }
            if(sum - current/2 >= n){
                sum -= current/2;
                current /= 2;
            }
            else{
                current /= 2;
                cnt++;
            }
        }
        System.out.println(cnt);
    }








}