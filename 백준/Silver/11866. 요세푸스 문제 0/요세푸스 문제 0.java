import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<n;i++) {
            q.add(i+1);
        }
        sb.append("<");
        while (!q.isEmpty()){
            for(int i = 0 ; i<k;i++){
                if(k-1 == i){
                    if(q.size() == 1){
                        sb.append(q.poll()+">");
                    }else {
                        sb.append(q.poll()+", ");
                    }

                }
                else{
                    q.add(q.poll());
                }
            }

        }
        System.out.println(sb);
    }


}





