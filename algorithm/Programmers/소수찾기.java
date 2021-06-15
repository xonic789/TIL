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
        int cnt = 1;

        // 처음부터 cnt를 늘려가면서 모든 수를 적재 할 것
        while(cnt <= n){
            if (cnt == 1){
                for (int j = 0; j < n; j++){
                    set.add(arr[j] - '0');
                }
            }else {
                for (int j = 0; j < n; j++){
                    StringBuilder sb = new StringBuilder();
                    sb.append(arr[j]);
                    for (int k = 0; k < n; k++){
                        if (j == k){
                            continue;
                        }
                        if (cnt > sb.length()){
                            sb.append(arr[k]);
                        }
                        if (sb.length() == cnt){

                            break;
                        }
                    }
                    set.add(Integer.parseInt(sb.toString()));
                }
            }

            cnt++;
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
    }
}
