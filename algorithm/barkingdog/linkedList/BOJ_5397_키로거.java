package algorithm.barkingdog.linkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_5397_키로거 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken());
        List<LinkedList<Character>> passwords = new ArrayList<>();
        for (int i = 0; i < L; i++){
            passwords.add(new LinkedList<>());
        }

        for (int i = 0; i < L; i++){
            st = new StringTokenizer(br.readLine());
            String inputKeys = st.nextToken();
            LinkedList<Character> password = passwords.get(i);
            ListIterator<Character> iter = password.listIterator(0);

            for (char inputKey : inputKeys.toCharArray()){
                if (inputKey == '<'){
                    if (iter.hasPrevious()) iter.previous();
                }else if (inputKey == '>'){
                    if (iter.hasNext()) iter.next();
                }else if (inputKey == '-'){
                    if (iter.hasPrevious()){
                        iter.previous();
                        iter.remove();
                    }
                }else {
                    iter.add(inputKey);
                }
            }
        }

        List<String> answer = new ArrayList<>();
        passwords.forEach(
                (list) -> { StringBuilder sb = new StringBuilder();
                    list.forEach(sb::append);
                answer.add(sb.toString());
                });
        answer.forEach(System.out::println);
    }
}


/**
10
ABC-<-
A<B<C
A
A
A
A
A
A
A
A
 */