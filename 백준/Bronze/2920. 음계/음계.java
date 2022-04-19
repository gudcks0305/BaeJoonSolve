import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ch = br.readLine().split(" ");
        int t = 1;
        for(int i = 1; i < ch.length; i++){
            int k = Integer.parseInt(ch[i-1]);
            int j = Integer.parseInt(ch[i]);
            if(j-k == 1){
                t = 1;
            } else if (j-k == -1) {
                t = 2;
            }else {
                t = 3;
                break;
            }
        }
        if (t == 1) {
            System.out.print("ascending");
        }else if(t==2){
            System.out.print("descending");
        }else {
            System.out.print("mixed");
        }



    }




}








