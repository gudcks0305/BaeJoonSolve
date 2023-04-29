class Solution {
    public int solution(int n, String control) {
        for(int i = 0; i < control.length(); i++){
            n += controller(control.charAt(i));
        }
        return n;
    }
    public int controller(char command){
        switch(command) {
            case 'w' : return 1;
            case 's' : return -1;
            case 'd' : return 10;
            case 'a' : return -10;
        }
        return -100;
    }
}