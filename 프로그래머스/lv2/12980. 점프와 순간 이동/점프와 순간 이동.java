import java.util.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
public class Solution {
    public  int solution(int n){
      int ans = 0;
      while (n != 0){
         if(n % 2 == 0) {
            n /= 2;
         } else {
            n -= 1;
            ans++;
         }

      }
        return ans;

   }
}