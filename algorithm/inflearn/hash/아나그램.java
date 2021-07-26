package algorithm.inflearn.hash;

import java.util.*;

public class 아나그램 {
    public static String solution(String a, String b){
        Map<Character, Integer> map = new HashMap<>();
        String answer = "YES";

        for (int i = 0; i < a.length(); i++){
            map.put(a.charAt(i), map.getOrDefault(a.charAt(i), 0) + 1);
        }

        for (int i = 0; i < b.length(); i++){
            char key = b.charAt(i);
            if (map.get(key) != null){
                int value = map.get(key);
                map.put(key , --value);
            }else{
                answer = "NO";
                return answer;
            }
        }

        for (char key : map.keySet()){
            if (map.get(key) != 0) {
                answer = "NO";
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();

        System.out.println(아나그램.solution(a,b));



        return ;
    }
}
