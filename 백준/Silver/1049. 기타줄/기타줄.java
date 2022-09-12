import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[m][2];
        // 0 패키지 6개 들이 가격 , 1 낱개 가격 , 2 패키지 개당 평균 가격
        for (int i =0 ; i < m; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());

        }
        double minPackage = Arrays.stream(arr).mapToInt(i -> i[0]).min().getAsInt();
        double minSingle = Arrays.stream(arr).mapToInt(i -> i[1]).min().getAsInt();
       
        int sum = 0;
        // n개 이상 기타 줄 구매 하기 위한 최소 가격
        while (n != 0) {
            if(n>=6){
                sum += Math.min(minPackage, minSingle * 6);
                n -= 6;
            }else {
                sum += Math.min(minPackage, minSingle * n);
                n = 0;
            }
        }
        System.out.println(sum);




    }


}








