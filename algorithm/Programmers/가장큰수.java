package algorithm.Programmers;

import java.util.Arrays;
import java.util.Comparator;

public class 가장큰수 {

    public static String solution(int[] numbers){
        String answer = "";
        int n = numbers.length;
        String[] str = new String[n];

        for (int i = 0; i < n; i++){
            str[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(str, (a,b) -> (b+a).compareTo(a+b));

        StringBuilder builder = new StringBuilder();

        for (String i : str){
            builder.append(i);
        }

        answer = builder.toString();

        if (answer.charAt(0) == '0'){
            return "0";
        }

        return answer;
    }

    public static void main(String[] args){
        int[] numbers = {6, 10, 2};

        System.out.println(solution(numbers));

    }
}
