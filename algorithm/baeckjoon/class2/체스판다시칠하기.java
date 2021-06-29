package algorithm.baeckjoon.class2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 체스판다시칠하기 {

    public static final char white = 'W';
    public static final char black = 'B';


    public static String[] initChessBoard(char color){
        String[] chessBoard = new String[8];
        if (color == 'W'){
            for (int i = 0; i < 8; i++){
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < 8; j++){
                    if (i % 2 == 0){
                        if (j % 2 == 0){
                            sb.append(white);
                        }else {
                            sb.append(black);
                        }
                    }else {
                        if (j % 2 == 0){
                            sb.append(black);
                        }else {
                            sb.append(white);
                        }
                    }
                }
                chessBoard[i] = sb.toString();
            }
        }else {
            for (int i = 0; i < 8; i++){
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < 8; j++){
                    if (i % 2 == 0){
                        if (j % 2 == 0){
                            sb.append(black);
                        }else {
                            sb.append(white);
                        }
                    }else {
                        if (j % 2 == 0){
                            sb.append(white);
                        }else {
                            sb.append(black);
                        }
                    }
                }
                chessBoard[i] = sb.toString();
            }
        }
        return chessBoard;
    }

    public static int getCount(String[] input, int ws, int we, int hs, int he){
        int cnt = 0;
        String[] chess = null;
        if (input[hs].charAt(ws) == 'W'){
            chess = initChessBoard('W');
        }else {
            chess = initChessBoard('B');
        }


        for (int i = hs; i <= he; i++){
            for (int j = ws; j <= we; j++){
                if (chess[i-hs].charAt(j-ws) != input[i].charAt(j)){
                    cnt++;
                }
            }
        }

        return cnt > 64 - cnt ? 64 - cnt : cnt;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        String[] chess = new String[n];

        for (int i = 0; i < n; i++){
            chess[i] = sc.nextLine();
        }
        int maxWidth = m;
        int maxHeight = n;

        int ws = 0;
        int hs = 0;
        int we = ws + 7;
        int he = hs + 7;


        while (true){
            if (we >= maxWidth){
                ws = 0;
                we = ws + 7;
                hs++;
                he++;
            }
            if (he >= maxHeight){
                break;
            }
            list.add(getCount(chess,ws,we,hs,he));
            ws++;
            we++;
        }

        int min = Integer.MAX_VALUE;
        for (int a : list){
            if (min > a){
                min = a;
            }
        }
        System.out.println(min);

    }


}
