package algorithm.inflearn.scanner;

import java.util.Scanner;

public class Main {

    public String solution(String input){
        int n = input.length();
        char[] arr = input.toCharArray();
        int lt = 0;
        int rt = n - 1;
        while (lt < rt){
            if (isAlpha(arr[lt]) && isAlpha(arr[rt])){
                swap(arr,lt,rt);
            }
            lt++;
            rt--;
        }
        return String.valueOf(arr);
    }

    public void swap (char[] arr, int lt, int rt){
        char tmp = arr[lt];
        arr[lt] = arr[rt];
        arr[rt] = tmp;
        StringBuilder sb = new StringBuilder();

    }

    public boolean isAlpha(char a){
        if (a >= 'A' && a <= 'Z' || a >= 'a' && a <= 'z'){
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        Main main = new Main();
        String input = in.nextLine();
        System.out.println(main.solution(input));

        return ;
    }
}
