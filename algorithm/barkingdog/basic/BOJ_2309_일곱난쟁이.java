package algorithm.barkingdog.basic;

import java.util.*;

public class BOJ_2309_일곱난쟁이 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] dwarfs = new int[9];
        for (int i = 0; i < 9; i++){
           dwarfs[i] = sc.nextInt();
        }
        Arrays.sort(dwarfs);
        for (int i = 0; i < 9; i++){
            int[] tmp = new int[9];
            for (int j = i+1; j < 9; j++){
                int sum = 0;
                for (int k = k = 0; k < 9; k++){
                    if (k == i || j == k) continue;
                    sum += dwarfs[k];
                    tmp[k] = dwarfs[k];
                }
                if (sum == 100) {
                    for (int a : tmp){
                        if (a != 0)
                            System.out.println(a);
                    }
                    return;
                }
                tmp = new int[9];
            }

        }
    }
}