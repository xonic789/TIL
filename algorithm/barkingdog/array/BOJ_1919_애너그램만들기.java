package algorithm.barkingdog.array;

import java.util.Scanner;

public class BOJ_1919_애너그램만들기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        int[][] arr = new int[2][26];


        //알파벳 개수 찾기
        for (char c : a.toCharArray()){
            arr[0][c - 'a']++;
        }
        for (char c : b.toCharArray()){
            arr[1][c - 'a']++;
        }

        int res = 0;
        // 0 ~ 25까지 돌면서
        // 해당 배열의 인덱스에 각 문자의 갯수를 빼준다.
        // 빼주는 이유는 다른 경우기 때문에 문자를 바꿔야하기 때문.
        // 같은 경우는 안 바꿔도 되기 때문에 연산하면 0이 나오고
        // 다른 경우는 빼주면 바꿔야할 갯수가 나옴.
        for (int i = 0; i < 26; i++){
            res += Math.abs(arr[0][i] - arr[1][i]);
        }
        System.out.println(res);


    }
}
