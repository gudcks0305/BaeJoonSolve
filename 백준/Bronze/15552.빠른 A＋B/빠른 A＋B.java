import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter rw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(rd.readLine());

        StringTokenizer st;
        for(int i = 0; i<T; i++){
            //rw.write(rd.read());
            st = new StringTokenizer(rd.readLine()," ");
            rw.write((Integer.parseInt(st.nextToken())) + (Integer.parseInt(st.nextToken())) +"\n");
        }

        rw.flush();
        rw.close();

    }
}
