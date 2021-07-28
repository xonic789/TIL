package algorithm.inflearn.hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 모든아나그램 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();

        System.out.println(모든아나그램.solution(s,t));

    }

    private static int solution(String s, String t) {
        Map<Character,Integer> sm = new HashMap<>();
        Map<Character, Integer> tm = new HashMap<>();
        int answer = 0;

        for (int i = 0; i < t.length(); i++){
            tm.put(t.charAt(i), tm.getOrDefault(t.charAt(i), 0) + 1);
        }

        for (int i = 0; i < t.length() - 1; i++){
            sm.put(s.charAt(i), sm.getOrDefault(s.charAt(i), 0 ) + 1);

        }


        int lt = 0;
        for (int rt = t.length() - 1; rt < s.length(); rt++){
            sm.put(s.charAt(rt), sm.getOrDefault(s.charAt(rt), 0 ) + 1);
            if (tm.equals(sm)){
                answer++;
            }
            sm.put(s.charAt(lt), sm.get(s.charAt(lt)) - 1);
            if (sm.get(s.charAt(lt)) == 0) sm.remove(s.charAt(lt));
            lt++;
        }
        return answer;
    }
}
