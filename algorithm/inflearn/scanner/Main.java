package algorithm.inflearn.scanner;

import java.util.Scanner;

public class Main {

    public String solution(String s){
        s += " ";
        StringBuilder answer = new StringBuilder();
        int n = s.length() - 1;
        int cnt = 1;
        for (int i = 0; i < n; i++){
            if (s.charAt(i) == s.charAt(i + 1)){
                cnt++;
            }else {
                answer.append(s.charAt(i));
                if (cnt > 1){
                    answer.append(cnt);
                }
                cnt = 1;
            }
        }


        return answer.toString();
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String s = in.nextLine();

        System.out.println(new Main().solution(s));

        System.out.println(0 % 7 == 0);
        return ;
    }
}