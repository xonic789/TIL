package algorithm.programmers;

import java.util.*;

public class K번째수 {
    public static List<Integer> solution(int[] array, int[][] commands) {
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < commands.length; i++){
            int from = commands[i][0] - 1;
            int to = commands[i][1] - 1;
            Integer[] arr = new Integer[to - from + 1];
            for (int j = 0; j < arr.length; j++){
                arr[j] = array[from++];
            }
            Arrays.sort(arr,(o1, o2) -> o1 - o2);
            answer.add(arr[commands[i][2] - 1]);
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {
                {2, 5, 3},
                {4, 4, 1},
                {1, 7, 3}
        };


        System.out.println(solution(array,commands));
    }
}
