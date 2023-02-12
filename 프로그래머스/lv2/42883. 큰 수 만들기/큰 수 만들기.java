class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        // k 길이 만큼 뺀 애들 중에서 가장 큰 숫자를 구한다.
        // 4177252841 , k = 4 인경우 선택 6 개 775841
        int choiceNums = number.length() - k;
        int curChoice = 0;
        int index = -1;
        for (int i = 0; i < choiceNums; i++) {
            // 최고로 큰애 고르자 , 조건은?
            // 이전에 선택했던 index 보다 크고 , 선택 했을 때 남은 초이스 횟수 < number.length() - index
            int maxNums = Integer.MIN_VALUE;
            for (int j = index + 1; j < number.length(); j++) {
                // 현재 값을 가져오고
                int value = Integer.parseInt(String.valueOf(number.charAt(j)));
                // 현재 남아있는 선택 횟수가 남아있는 길이보다 작거나 같아야함
                if (choiceNums - curChoice <= number.length() - j) {
                    if (value > maxNums) {
                        maxNums = value;
                        index = j;
                    }
                }
                if(value == 9) break;
            }

            curChoice++; // 선택 횟수 올리고
            sb.append(maxNums);

        }

        return sb.toString();
    }
}