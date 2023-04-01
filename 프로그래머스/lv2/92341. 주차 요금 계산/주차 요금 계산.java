import java.util.*;
class Solution {
    // 입차 시간 , 차량 번호 , 인아웃 
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        // 입차 출차 map 으로 구분 하여 나눈 후 처리
        // 전체 입차 처리 // 이미 존재하는 차량이면 출차처리 
        // 차량번호 , 출차 시간 
        Map<Integer,Integer> input = new HashMap<>();
        Map<Integer,Integer> result = new HashMap<>();
        for(String record : records){
            String[] recordArr = record.split(" ");
            int inOutTime = stringToIntTime(recordArr[0]);
            int carNums = Integer.parseInt(recordArr[1]);
            String inOut = recordArr[2];
            // 있으니까 출차처리 해야쥐?
            if(input.containsKey(carNums)){
                int time = inOutTime - input.get(carNums);
                result.put(carNums, result.getOrDefault(carNums,0) + time);
                input.remove(carNums);
                
            }else{
               input.put(carNums ,inOutTime);
            }
        }
        // out 남아있는 애들 출차처리 
        int lastTime = stringToIntTime("23:59");
        for(Map.Entry<Integer,Integer> entry : input.entrySet()){
             int time = lastTime - input.get(entry.getKey());
            result.put(entry.getKey(), result.getOrDefault(entry.getKey(),0) + time);
        }
        List<Map.Entry<Integer,Integer>> resultEntry = new LinkedList<>(result.entrySet());
        Collections.sort(resultEntry , (o1,o2) -> o1.getKey() - o2.getKey());
        System.out.println(resultEntry);
        answer = new int[resultEntry.size()];
        int i = 0;
        for(Map.Entry<Integer,Integer> entry : resultEntry){
            int resultFee =calulateFees(fees , entry.getValue());
            System.out.println(resultFee);
            answer[i] = resultFee;
            i++;
        }
        // input 남아있는 경우 23:59 기준 출차처리 
        
        // 출차 내역 없으면 23:59 기준으로 출차 처리 
        return answer;
    }
    public int stringToIntTime(String times){
        // ex 05:22 
        String[] timeArr = times.split(":");
        int hours = Integer.parseInt(timeArr[0]);
        int minutes = Integer.parseInt(timeArr[1]);
        return hours * 60 + minutes;
    }
    public int calulateFees(int[] fees , int time){
        // 기본 시간 , 기본 요금 , 단위 시간 , 단위 요금 
        // 주차 요금 계산 = 기본요금 + (출차시각 - 입차시각 - 기본 시간)->올림 /  단위 시간 * 단위 요금 
        int basicTime = fees[0];
        int basicFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];
        int cal = (int) Math.ceil((time - fees[0]) / (double)fees[2]) * fees[3];
        if(cal < 0) cal = 0;
        return fees[1] + cal;
    }
}