package kakao2021;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Question3 {

    public static final String IN = "IN";
    public static final String OUT = "OUT";

    public List<Integer> solution(int[] fees, String[] records) {
        List<Integer> answer = new ArrayList<>();
        int basicTime = fees[0];
        int basicFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];
        Map<String, Integer[]> map = new TreeMap<>();
        Map<String, Integer> actimeForVehicles = new TreeMap<>();
        for (String record : records){
            String[] s = record.split(" ");
            String[] time = s[0].split(":");
            int changeMinutes = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
            String carNumber = s[1];
            String act = s[2];
            if (act.equals(IN)){
                Integer[] inTime = {changeMinutes, 0};
                map.put(carNumber, inTime);
            }
            if (act.equals(OUT)){
                // 요금 청산 및 누적
                Integer[] times = map.get(carNumber);
                times[1] = changeMinutes;
                int timeToUseIt = times[1] - times[0];
                actimeForVehicles.put(carNumber, actimeForVehicles.getOrDefault(carNumber, 0) + timeToUseIt);
            }
        }

        for (String key : map.keySet()){
            Integer[] times = map.get(key);
            if (times[1] == 0) actimeForVehicles.put(key, actimeForVehicles.getOrDefault(key, 0) + (23 * 60 + 59) - times[0]);
            int timeToUseIt = actimeForVehicles.get(key);
            int amount = 0;
            if (timeToUseIt <= basicTime) amount = basicFee;
            else amount = basicFee + (int) Math.ceil(((double) timeToUseIt - basicTime) / unitTime) * unitFee;
            answer.add(amount);
        }



        return answer;
    }

    public static void main(String[] args) {
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        System.out.println(new Question3().solution(fees, records));
    }
}
