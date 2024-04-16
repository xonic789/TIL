package algorithm.barkingdog.basic;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class BOJ_2440_star3 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = sc.nextInt();
        for (int i = n; i >= 0; i--){
            for (int j = 0; j < i; j++){
                bw.write("*");
            }
            bw.write("\n");
        }
        bw.flush();
    }
}
