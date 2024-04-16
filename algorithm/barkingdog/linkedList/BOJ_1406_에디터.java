package algorithm.barkingdog.linkedList;

import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class BOJ_1406_에디터 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] text = st.nextToken().toCharArray();
        LinkedList<Character> list = new LinkedList<>();
        int n = text.length;
        for (int i = 0; i < n; i++){
            list.add(text[i]);
        }
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        ListIterator<Character> iter = list.listIterator(list.size());


        for (int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("D")) {
                if (iter.hasNext()) iter.next();
            }else if (command.equals("L")){
                if (iter.hasPrevious()) iter.previous();
            }else if (command.equals("B")){
                if (iter.hasPrevious()){
                    iter.previous();
                    iter.remove();
                }
            }else{
                char c = st.nextToken().charAt(0);
                iter.add(c);
            }
        }

        for (char ch : list){
            bw.write(ch);
        }
        bw.flush();
    }
}
