package algorithm;


import java.util.LinkedList;
import java.util.Queue;

public class Test {
    public int solution(String s) {
        String[] numArr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for (int i = 0; i < numArr.length; i++){
            if (s.contains(numArr[i])){
                s = s.replace(numArr[i],String.valueOf(i));
            }
        }

        return Integer.parseInt(s);
    }

    public static void main(String[] args) {
        System.out.println(new Test().solution("one4seveneight"));
    }


}
