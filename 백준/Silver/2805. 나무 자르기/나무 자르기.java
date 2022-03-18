import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.IntStream;;

public class Main {
    static int[] arr;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        int start = 0;
        int end = 0;
        st = new StringTokenizer(br.readLine() , " ");
        for(int i = 0 ; i< arr.length;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>end) end = arr[i];
        }

        while (start + 1 < end) {
            int mid = (start+end)/2;
            if(check(mid)){
                start = mid;
            }else end = mid;
        }
        System.out.println(start);
    }

    public static boolean check(int mid) {
        long sum = 0;
        long result;
        long tree;
        for (int i = 0; i < arr.length; i++) {
            tree = arr[i];
            if(tree>=mid){
                result = tree - mid;
                sum+=result;
            }
        }
        if (sum >= M) {
            return true;
        }else return false;
    }
}

