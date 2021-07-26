package algorithm.baeckjoon.class1;

import java.util.Scanner;

public class 알파벳찾기 {

    public static int indexOf(String str,char ch){
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == ch){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        for (char i = 'a'; i <= 'z'; i++){
            System.out.print(indexOf(str,i) + " ");
        }
    }
}
