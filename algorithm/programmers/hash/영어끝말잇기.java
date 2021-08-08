package algorithm.programmers.hash;
import java.util.*;

public class 영어끝말잇기 {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        Map<String, Integer> map = new HashMap<>();
        Map<Integer, Integer> people = new HashMap<>();


        for (int i = 0; i < words.length; i++){
            String word = words[i];
            if (i != 0 && word.charAt(0) != words[i - 1].charAt(words[i - 1].length() - 1)){
                // 사람 번호
                answer[0] = i % n + 1;
                // 몇 번째
                answer[1] = people.get(i%n + 1) + 1;
                break;
            }

            if (map.get(word) == null){
                map.put(word , 1);
                people.put(i % n + 1, people.getOrDefault(i % n + 1, 0) + 1);
            }else {
                // 사람 번호
                answer[0] = i % n + 1;
                // 몇 번째
                answer[1] = people.get(i%n + 1) + 1;
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 2;
        String[] words = {"hello", "one", "even", "never", "now", "world", "draw"};
        int[] answer = new 영어끝말잇기().solution(n,words);
        System.out.println(answer[0] + " " + answer[1]);
    }

}
