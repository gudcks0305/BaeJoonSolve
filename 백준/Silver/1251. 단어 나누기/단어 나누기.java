import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        ArrayList<String> list = new ArrayList<>();
        // 주어진 단어를 세 개의 더 작은 단어로 나눈다. 각각은 적어도 길이가 1 이상인 단어여야 한다.
        for (int i = 1; i < s.length() - 1; i++) {
            for (int j = i + 1; j < s.length(); j++) {
                StringBuffer sb = new StringBuffer();
                String s1 = s.substring(0, i);
                String s2 = s.substring(i, j);
                String s3 = s.substring(j);
                // 나눠진 세 개의 단어를 조합하여 새로운 단어를 만든다.
                s1 = sb.append(s1).reverse().toString();
                s2 = sb.delete(0, sb.length()).append(s2).reverse().toString();
                s3 = sb.delete(0, sb.length()).append(s3).reverse().toString();
                String newWord = s1 + s2 + s3;
                // 새로운 단어를 리스트에 추가한다.
                list.add(newWord);
            }
        }
        // 리스트를 정렬한다.
        list.sort(String::compareTo);
        // 리스트의 첫 번째 단어를 출력한다.
        System.out.println(list.get(0));


    }








}