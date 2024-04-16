package algorithm.inflearn.hash;

import java.util.*;

public class 학급회장 {

    public static char solution(String str, int n){
        char answer = ' ';
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++){
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
        }

        int max = Integer.MIN_VALUE;
        for (char key : map.keySet()){
            int value = map.get(key);
            if (value > max){
                answer = key;
                max = value;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String str = in.nextLine();
        System.out.println(solution(str,n));
    }
}

