package algorithm.barkingdog.basic;

import java.math.BigInteger;
import java.util.Scanner;

public class BOJ_10093_숫자 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long start = sc.nextLong();
        long end = sc.nextLong();
        if (start > end){
            long tmp = end;
            end = start;
            start = tmp;
        }
        if (start == end || end - start == 1) System.out.println(0);
        else {
            long cnt = end - start - 1;
            System.out.print(cnt + "\n");
            for (long i = start + 1; i < end; i++) {
                System.out.print(i + " ");
            }
        }
    }
}
//999999999900001 1000000000000000