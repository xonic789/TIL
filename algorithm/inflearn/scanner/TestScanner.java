package algorithm.inflearn.scanner;

import java.util.*;
import java.util.Scanner;

public class TestScanner {

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String target = in.nextLine();
        List<Character> answer = new ArrayList<>();

        for (int i = 0; i < target.length(); i++){
            if (target.indexOf(target.charAt(i)) == i){
                answer.add(target.charAt(i));
            }
        }

        for(char chr : answer){
            System.out.print(chr);
        }
        return ;
    }
}
