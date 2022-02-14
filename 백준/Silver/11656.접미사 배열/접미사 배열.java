import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        ArrayList<String> arrayList = new ArrayList<>();
        String word = br.readLine();

        for (int i = 0; i < word.length(); i++) {
            arrayList.add(word.substring(i, word.length() ));
        }
        Collections.sort(arrayList);
        for (String val : arrayList) {
            System.out.println(val);
        }


    }


}