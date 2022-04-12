import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            boolean isLeft = true;
            boolean check = true;
            String[] method = br.readLine().split("");
            int number = Integer.parseInt(br.readLine());
            String[] arrValue = br.readLine()
                    .replace("[","")
                    .replace("]","").split(",");
            Deque<Integer> list = new LinkedList<>();
            for (int i = 0; i < arrValue.length; i++) {
                if(!arrValue[i].equals("")) list.add(Integer.parseInt(arrValue[i]));
            }
            for (String s : method) {
                if (s.equals("R")) isLeft = !isLeft;
                if (s.equals("D")) {
                    if(list.isEmpty()) {
                        sb.append("error").append("\n");
                        check = false;
                        break;
                    }
                    if(isLeft){
                        list.removeFirst();
                    }else {
                        list.removeLast();
                    }
                }
            }
            if(check){
                int size = list.size();
                sb.append("[");
                if(isLeft){
                    for (int i = 0; i < size; i++) {
                        if(i == size-1) sb.append(list.poll());
                        else sb.append(list.poll()).append(",");
                    }
                }else {
                    for (int i = 0; i < size; i++) {
                        if(i == size-1) sb.append(list.pollLast());
                        else sb.append(list.pollLast()).append(",");
                    }
                }
                sb.append("]").append("\n");

            }


        }
        System.out.println(sb);



    }



}





