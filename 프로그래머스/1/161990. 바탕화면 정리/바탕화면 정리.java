class Solution {
    public int[] solution(String[] wallpaper) {
        // 각 ROW 를 조사 해서 FILE 의 최소 최대 좌표를 구한다. 
        // answer 0 1 시작 좌표 , answer 2 3 끝 좌표
        // MIN X MIN Y , MAX X MAX Y 
        int minX = 99999, minY = 99999 , maxX = 0, maxY = 0;
        for(int j = 0; j < wallpaper.length; j++){
            String wall = wallpaper[j];
            System.out.println(wall);
            for(int i = 0; i < wall.length(); i++) {
                if (wall.charAt(i) == '#' ){
                    minX = allocateMinValue(j,minX);
                    minY = allocateMinValue(i,minY);
                    maxX = allocateMaxValue(j,maxX);
                    maxY = allocateMaxValue(i,maxY);
                }
            }
        }
        return new int[]{minX,minY,maxX + 1,maxY + 1};
    }
    private int allocateMinValue(int newValue , int storedValue){
        if(newValue < storedValue){
            return newValue;
        }
        return storedValue;
    }
    private int allocateMaxValue(int newValue , int storedValue){
        if (newValue > storedValue){
            return newValue;
        }
        return storedValue;
    }
}