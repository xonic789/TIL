package algorithm;

import java.util.Scanner;

public class ScannerArr {

    public int[] getArr(int n){
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        return arr;
    }
}
