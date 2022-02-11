import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int n = Integer.parseInt(br.readLine());
        String sp[];

        int[][] people = new int[n][2];
        for (int i = 0; i < n; i++) {
            sp=br.readLine().split(" ");
            people[i][0] = Integer.parseInt(sp[0]);
            people[i][1] = Integer.parseInt(sp[1]);
        }

        for (int i = 0; i < n; i++) {
            int rank=1;
            for (int j = 0; j < n; j++) {
                if(i==j)continue;
                if(people[i][0]<people[j][0] && people[i][1]<people[j][1]) rank++;

            }
            System.out.print(rank+" ");
        }



    }


}
