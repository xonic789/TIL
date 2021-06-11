package algorithm.inflearn.scanner;

import java.util.Scanner;

public class TestScanner {

    private static boolean isAlphabetic(char chr){
        if ((chr >= 'A' && chr <= 'Z') || (chr >= 'a' && chr <= 'z')){
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        char[] tmp = in.nextLine().toCharArray();
        int lt = 0, rt = tmp.length - 1;
        char[] target = String.valueOf(tmp).toCharArray();

        while (lt <= rt){

            if (isAlphabetic(target[lt]) && isAlphabetic(target[rt])){
                char temp = tmp[lt];
                tmp[lt] = tmp[rt];
                tmp[rt] = temp;
            }
            lt++;
            rt--;
        }



        System.out.println(String.valueOf(tmp));

        return ;
    }
}
