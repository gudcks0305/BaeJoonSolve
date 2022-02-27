import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        double[] arr = new double[N];
        double max;
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        max = arr[arr.length-1];
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i]/max * 100;
            
            sum += arr[i];
        }

        double avg = sum/arr.length;
        System.out.println(avg);



    }
}