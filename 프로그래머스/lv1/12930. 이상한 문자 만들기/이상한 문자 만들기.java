class Solution {
    public String solution(String s) {
        String[] words = s.split(" " , -1);
        for (int i = 0 ; i < words.length;i++){
            char[] word  = words[i].toCharArray();
            for (int j = 0 ; j < word.length;j++){
                if(j % 2 == 0) word[j] =  String.valueOf(word[j]).toUpperCase().charAt(0);
                else{
                    word[j] =  String.valueOf(word[j]).toLowerCase().charAt(0);
                }

            }
            words[i] = new String(word);
        }
        return String.join(" ", words);
    }
}