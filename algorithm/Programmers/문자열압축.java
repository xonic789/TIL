package algorithm.Programmers;

import java.util.Stack;

public class 문자열압축 {
    public static int solution(String s) {
        int answer = 0;

        int min = Integer.MAX_VALUE;

        int index = 0;
        int n = s.length();
        for (int i = 1; i <= n/2; i++){
            StringBuilder sb = new StringBuilder();
            String tmp = s.substring(0,i);
            int cnt = 1;
            for (int j = i; j < n + 1 ; j += i){
                int subIndex = j + i;
                String obj;
                // aabbaccc
                // 1
                // 0 1, 1 2, 2 3, 3 4, 4 5, 5 6, 6 7, 7 8
                // 2
                // 0 2, 2 4, 4 6, 6 8 , 10
                // 3
                // 0 3, 3 6, 6 9, 9
                // 4
                // 0 4, 4 8

                if (subIndex >= n){
                    obj = s.substring(j);
                }else {
                    obj = s.substring(j, subIndex);
                }


                if (tmp.length() == obj.length()){
                    if (tmp.equals(obj)){
                        cnt++;
                    }else {
                        if (cnt != 1){
                            sb.append(cnt+tmp);
                            tmp = obj;
                            cnt = 1;
                        }else {
                            sb.append(tmp);
                            tmp = obj;
                        }
                    }
                }else {
                    if (cnt != 1){
                        sb.append(cnt+tmp);
                    }else {
                        sb.append(tmp);
                        sb.append(obj);
                    }
                }
            }
            if (sb.length() < min){
                min = sb.length();
            }
        }

        return min;
    }

    public static void main(String[] args) {
        System.out.println(solution("abcabcabcabcdededededede"));
    }

}
