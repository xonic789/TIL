package algorithm.Programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 실패율 {

    public List<Integer> solution(int N, int[] stages){
        Map<Integer, Double> map = new HashMap<>();
        for (int i = 1; i <= N + 1; i++){

            for (int j = 0; j < stages.length; j++){

                if (i < stages[i]){

                }else if (i == stages[i]){

                }
            }
        }

    }

    public static void main(String[] args) {
        int N  = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
        System.out.println(new 실패율().solution(N,stages));
    }

}
