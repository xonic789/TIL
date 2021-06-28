package algorithm.baeckjoon.class1;

import java.util.*;

public class 단어_공부 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().toUpperCase();
        Map<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < str.length(); i++){
            char tmp = str.charAt(i);
            if (hm.get(tmp) != null){
                int cnt = hm.get(tmp);
                hm.put(tmp, ++cnt);
            }else {
                hm.put(tmp, 1);
            }
        }

        char ch = '?';
        int max = 0;
        for (char key : hm.keySet()){
            if (hm.get(key) > max){
                max = hm.get(key);
                ch = key;
            }else if (hm.get(key) == max){
                ch = '?';
            }
        }

        System.out.println(ch);
    }


}
