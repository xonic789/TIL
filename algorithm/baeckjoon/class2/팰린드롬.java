package algorithm.baeckjoon.class2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 팰린드롬 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> list = new ArrayList<>();

        while (true){
            String str = sc.nextLine();
            if (str.charAt(0) == '0'){
                break;
            }
            int lt = 0;
            int rt = str.length() - 1;
            String tmp = "yes";
            while (lt < rt){
                if (str.charAt(lt) != str.charAt(rt)){
                    tmp = "no";
                    break;
                }
                lt++;
                rt--;
            }
            System.out.println(tmp);
        }

    }
}
