package algorithm.goorm;

import java.io.*;

public class Goorm_BinarySearch {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] inputs = br.readLine().split(" ");
        for (int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(inputs[i]);
        }
        int target = Integer.parseInt(br.readLine());
        int answer = binarySearch(arr, target);
        if (answer != -1) {
            System.out.println(answer);
        } else {
            System.out.println("X");
        }
    }

    public static int binarySearch(int[] arr, int target) {
        int lt = 0, rt = arr.length - 1;

        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (target == arr[mid]) return mid + 1;
            if (arr[mid] > target) rt = mid - 1;
            else if (arr[mid] < target) lt = mid + 1;
        }
        return -1;
    }
}
