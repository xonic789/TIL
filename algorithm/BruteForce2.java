package algorithm;

import java.util.Arrays;

public class BruteForce2 {

    static int bfMatch(String text, String pattern){
        int count = 0;
        int pt = 0;
        int pp = 0;
        int tmp = 0;

        while (pt != text.length() && pp != pattern.length()){
            StringBuilder sb = new StringBuilder();
            System.out.println(text);
            count++;

            if (text.charAt(pt) == pattern.charAt(pp)){

                for (int i = 0; i < pt; i++){
                    sb.append(" ");
                }
                sb.append("+");
                System.out.println(sb);
                sb = new StringBuilder();
                for (int i = 0; i < tmp; i++){
                    sb.append(" ");
                }
                System.out.println(sb + pattern);
                pt++;
                pp++;
            }else {
                for (int i = 0; i < pt; i++){
                    sb.append(" ");
                }
                sb.append("|");
                System.out.println(sb);
                sb = new StringBuilder();
                for (int i = 0; i < tmp; i++){
                    sb.append(" ");
                }
                System.out.println(sb + pattern);
                pt = pt - pp + 1;
                tmp = pt;
                pp = 0;
            }
        }



        return count;
    }

    public static void main(String[] args) {
        int idx = bfMatch("ABABCDEFGHA","ABC");
        System.out.println(idx);
    }
}
