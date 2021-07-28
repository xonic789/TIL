package algorithm.programmers;

import java.util.*;

public class 실패율 {

    public List<Integer> solution(int N, int[] stages){
        Map<Integer, Double> map = new HashMap<>();

        for (int i = 1; i <= N; i++){
            int unSolved = 0;
            int solved = 0;
            for (int j = 0; j < stages.length; j++){
                if (i < stages[j]){
                    solved++;
                }else if (i == stages[j]){
                    unSolved++;
                }
            }
            if (solved == 0)
                map.put(i, 0.0);
            else
                map.put(i, (double)unSolved/solved);
        }
        List<Integer> listKeySet = new ArrayList<>(map.keySet());

        Collections.sort(listKeySet, ((o1, o2) -> (map.get(o2).compareTo(map.get(o1)))));

        return listKeySet;
    }

    public static void main(String[] args) {
        int N  = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
        System.out.println(new 실패율().solution(N,stages));
    }

}
