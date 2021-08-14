package algorithm.barkingdog.array;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class BOJ_10808_알파벳개수 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = sc.nextLine();
        int[] arr = new int[26];
//        char ch = 'a';
//        for (int i = 0; i < 26; i++){
//            for (char a : input.toCharArray()){
//                if (a == ch) arr[i]++;
//            }
//            ch++;
//        }
//        for (int e : arr){
//            bw.write(e + " ");
//        }
        for (char ch : input.toCharArray()){
            arr[ch - 'a']++;
        }

        for (int i = 0; i < 26; i++){
            bw.write(arr[i] + " ");
        }
        bw.flush();
    }
}
