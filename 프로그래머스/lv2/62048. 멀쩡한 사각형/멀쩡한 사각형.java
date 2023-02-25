class Solution {
    public  long solution(int w, int h) {
        long answer = (long) w * h;
        // 일차 방정식  y = ( h/w ) x  y를 올림 내림한 between 사이에 있는 좌표 개수 구하기
        // y == i 또는 x = i 일 때 정수가 아닐 경우
        // 프로그래머스 멀쩡한 사각형
        // w, h : 1억 이하의 자연수

        // 1. w, h의 최대공약수를 구한다.
        // 2. w, h를 최대공약수로 나눈다.
        // 3. 최대공약수 * (w/gcd) * (h/gcd) - (w/gcd + h/gcd - 1) = 정답

        int gcd = gcd(w, h);
        int w2 = w / gcd;
        int h2 = h / gcd;
        answer -= (long) gcd * (w2 + h2 - 1);
        return answer;
    }

    private static int gcd(int w, int h) {
        if (w % h == 0) return h;
        return gcd(h, w % h);
    }
}