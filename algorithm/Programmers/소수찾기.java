package algorithm.Programmers;
import java.util.*;

public class 소수찾기 {

    private static boolean isPrime(int num){
        if (num < 2){
            return false;
        }

        for (int i = 2; i < num; i++){
            if (num % i == 0){
                return false;
            }
        }

        return true;
    }

    public static int solution(String numbers) {
        int answer = 0;
        char[] arr = numbers.toCharArray();
        int n = arr.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++){
            set.add(arr[i] - '0');
        }

        // 한자리
        for (int i = 1; i <= n; i++){
            for (int j = 0; j < i; j++){
                StringBuilder sb = new StringBuilder();
                sb.append(arr[j]);
                for (int k = 0; k < i; k++){
                    if (j == k){
                        continue;
                    }
                    sb.append(arr[k]);
                }
                set.add(Integer.parseInt(sb.toString()));
            }
        }



        for (int number : set){
            if (isPrime(number)){
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("17"));
        System.out.println(solution("011"));

        System.out.println(3 % 2);
    }
}
