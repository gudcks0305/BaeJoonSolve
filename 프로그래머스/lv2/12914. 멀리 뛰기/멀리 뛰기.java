class Solution {
    static int count = 0;

   public  long solution(int n) {
       long[] memo = new long[2001];
      memo[1] = 1;
      memo[2] = 2;

      for (int i = 3; i <= n; i++) {
         memo[i] = (memo[i - 1] + memo[i - 2]) % 1234567;
      }

      return memo[n];
   }
   public static void combination(int goalNum , int curNums) {
      if(goalNum == curNums) count = count % 1234567 + 1;
      if(goalNum < curNums) return;
      combination(goalNum,curNums + 1);
      combination(goalNum,curNums + 2);
   }
}