package algorithm.Programmers.queue;

import java.util.*;

public class 다리를_지나는_트럭 {
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int bridge_weight = 0;
        int cnt = 0;
        Queue<Integer> trucks = new LinkedList<>();
        Queue<Integer> bridge = new LinkedList<>();

        for (int i = 0; i < truck_weights.length; i++){
            trucks.add(truck_weights[i]);
        }
        for (int i = 0; i < bridge_length; i++){
            bridge.add(0);
        }

        while (trucks.size() > 0){
            cnt++;
            int out = bridge.remove();
            bridge_weight -= out;

            if (trucks.peek() + bridge_weight < weight){
                int truck = trucks.remove();
                bridge_weight += truck;
                bridge.add(truck);
            }else {
                bridge.add(0);
            }
        }

        while (bridge.size() > 0){
            bridge.remove();
            cnt++;
        }



        answer = cnt;

        return answer;
    }

    public static void main(String[] args) {
        int[] truck_weights = {7,4,5,6};

        System.out.println(solution(2,10,truck_weights));

    }
}
