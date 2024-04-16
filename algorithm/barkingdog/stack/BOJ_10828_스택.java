package algorithm.barkingdog.stack;

import java.io.*;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_10828_스택 {

    static class Stack{
        Integer[] arr;
        int size;
        int pt;

        Stack(){
            this.size = 100;
            this.arr = new Integer[size];
        }

        Stack(int size){
            this.size = size;
        }

        void push(Integer element){
            if (size == pt) {
                reSize();
            }
            arr[pt++] = element;
        }

        private void reSize() {
            Integer[] tmp = new Integer[size*2];
            if (size >= 0) System.arraycopy(arr, 0, tmp, 0, size);
            this.arr = tmp;
        }

        Integer pop(){
            if (isEmpty() == 0) {
                int ele = arr[pt-1];
                arr[--pt] = null;
                return ele;
            }
            return -1;
        }

        int isEmpty(){
            return pt == 0 ? 1 : 0;
        }

        Integer size(){
            return pt;
        }

        Integer top(){
            if (pt == 0) return -1;
            return arr[pt-1];
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            Arrays.stream(arr).filter(Objects::nonNull).forEach((num) -> sb.append(num+" "));
            return sb.toString();
        }
    }


    public static void main(String[] args) throws IOException {
        Stack stack = new Stack();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("push")){
                int e = Integer.parseInt(st.nextToken());
                stack.push(e);
            }else if (command.equals("top")){
                System.out.println(stack.top());
            }else if (command.equals("size")){
                System.out.println(stack.size());
            }else if (command.equals("empty")){
                System.out.println(stack.isEmpty());
            }else {
                System.out.println(stack.pop());
            }

        }
    }
}
