package kakao2021;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Question2 {

    public int solution(int n, int k) {
        int answer = 0;
        String convert = convert(n, k);

        while (convert.length() > 0){
            String tmp = "";
            int i = 0;
            for (; i < convert.length(); i++){
                if (convert.charAt(i) == '0') {
                    if (tmp.length() >= 1) break;
                }else tmp += String.valueOf(convert.charAt(i));
            }
            convert = convert.substring(i);
            if (tmp.length() == 0) continue;
            if (isPrime(Long.parseLong(tmp))) answer++;
        }

        return answer;
    }

    private boolean isPrime(long parseInt) {
        if (parseInt < 2) return false;
        for (long i = 2; i <= Math.sqrt(parseInt); i++){
            if (parseInt % i == 0) return false;
        }
        return true;
    }

    String convert(int n, int k){
        String convert = "";
        while (n > 0){
            convert = n % k + convert;
            n /= k;
        }
        return convert;
    }

    public static void main(String[] args) {
        int n = 437674;
        int k = 3;
        System.out.println(new Question2().solution(n, k));
    }
}
