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
        // n이 되어야 할 수
        // 처음부터 cnt를 늘려가면서 모든 수를 적재 할 것
        permutation("",numbers,set);

        for (int number : set){
            if (isPrime(number)){
                answer++;
            }
        }

        return answer;
    }

    public static void permutation(String prefix, String str, Set<Integer> set) {
        int n = str.length();
        if(!prefix.equals("")) {
            set.add(Integer.valueOf(prefix)); //스트링을 Interger로 변환
        }

        for (int i = 0; i < n; i++){
            // prefix를 ""부터 진행시키며, 해당 문자열의 i번째를 매번 prefix와 더해준다.
            //
            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n), set);
        }
    }
    public static void main(String[] args) {
        System.out.println(solution("17"));
        System.out.println(solution("011"));
        System.out.println(solution("0123"));
    }
}
