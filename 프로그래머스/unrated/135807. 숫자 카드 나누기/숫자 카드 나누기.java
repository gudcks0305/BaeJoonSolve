import java.util.*;
class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int maxA =  arrayA.length == 1 ? arrayA[0] :  gcd(arrayA[0] , arrayA[1]);
        for(int i = 2; i < arrayA.length; i++){
            maxA =  gcd(maxA , arrayA[i]);
        }
        if(isPossible(arrayB , maxA)){
            maxA = 0;
        }
        
        int maxB =  arrayB.length == 1 ? arrayB[0] :  gcd(arrayB[0] , arrayB[1]);
        for(int i = 2; i < arrayB.length; i++){
            maxB =  gcd(maxB , arrayB[i]);
        }
        if(isPossible(arrayA , maxB)){
            maxB = 0;
        }
        return Math.max(maxA,maxB);
    }
    public boolean isPossible(int[] array , int nums){
        for(int i = 0; i < array.length; i++){
            if(array[i] % nums == 0) return true;
        }
        return false;
    }
    public int gcd(int n,int m){
         int r;
        while(m > 0) {
            r = n % m;
            n = m;
            m = r;
        }
        return n;
    }
}