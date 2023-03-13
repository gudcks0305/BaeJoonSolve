import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
class Solution {
     public static int MIN_COST = Integer.MAX_VALUE;
    public static List<Direction> directionList = List.of(Direction.values());

    public int solution(int[][] board) {
        boolean[][] visited = new boolean[board.length][board.length];
        int[][][] cost = new int[board.length][board.length][4];
        //sol(board,visited,first_car);
        Queue<Car> carQueue = new LinkedList<>();
        for (Direction direction : directionList){
            Car firstDirCar = new Car(0,0,direction,0);
            carQueue.add(firstDirCar);
        }
        while (!carQueue.isEmpty()){
            Car currentCar = carQueue.poll();
            if (currentCar.isDestination(board)){
                MIN_COST = Math.min(MIN_COST , cost[currentCar.getY()][currentCar.getX()][currentCar.getDirection().seq]);
                continue;
            }
            for (Direction direction : directionList) {
                int nextY = currentCar.getY() + direction.getY();
                int nextX = currentCar.getX() + direction.getX();
                if (isAbleToGo(board, nextY, nextX)) {
                    visited[nextY][nextX] = true;
                    Car nextCar = Car.clone(currentCar, direction);
                    if (currentCar.getDirection() != direction) {
                        nextCar.addCornerCost();
                    }
                    nextCar.addRoadCost();
                    if (nextCar.getCurrentCost() > cost[nextY][nextX][direction.seq] && cost[nextY][nextX][direction.seq] != 0){
                        continue;
                    }
                    carQueue.add(nextCar);
                    cost[nextY][nextX][direction.seq] = nextCar.getCurrentCost();
                }
            }

        }
        return MIN_COST;
    }
    public static void printArray(int[][] curCost){
        for (int i = 0; i < curCost.length; i++) {
            System.out.println(Arrays.toString(curCost[i]));
        }
        System.out.println();
    }
    public static boolean isAbleToGo(int[][] board , int nextY , int nextX){
        if (nextY < 0 || nextY > board.length -1 || nextX < 0 || nextX > board[0].length - 1) return false;
        if (board[nextY][nextX] == 1) return false;
        return true;
    }
    public static class Car {
        // 세로 위치  [][] 중 첫번째
        private int y;
        // 가로 위치

        //[][] 중 두번째
        private int x;
        private Direction direction;

        public Car(int y, int x, Direction direction, int currentCost) {
            this.y = y;
            this.x = x;
            this.direction = direction;
            this.currentCost = currentCost;
        }

        private int currentCost;

        public int getY() {
            return y;
        }

        public int getX() {
            return x;
        }

        public Direction getDirection() {
            return direction;
        }


        public static Car clone(Car car, Direction direction) {
            return new Car(car.getY() + direction.getY(), car.getX() + direction.getX(), direction, car.currentCost);
        }
        public boolean isDestination(int[][] board){
            return this.getY() == board.length - 1 && this.getX() == board[0].length - 1;
        }

        public int getCurrentCost() {
            return currentCost;
        }
        public void addCornerCost(){
            this.currentCost += 500;
        }
        public void addRoadCost(){
            this.currentCost += 100;
        }
    }

    public enum Direction {
        UP(-1, 0 , 0),
        DOWN(1, 0,1),
        LEFT(0, -1,2),
        RIGHT(0, 1,3);

        final int y;
        final int x;
        final int seq;

        Direction(int y, int x , int seq) {
            this.y = y;
            this.x = x;
            this.seq = seq;
        }

        public int getY() {
            return y;
        }

        public int getX() {
            return x;
        }
    }
}