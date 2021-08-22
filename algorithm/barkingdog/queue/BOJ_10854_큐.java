package algorithm.barkingdog.queue;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_10854_큐 {

    static class Queue{
        private int[] arr;
        private int front;
        private int back;
        private int size;

        Queue(){
            this.arr = new int[20000001];
        }

        public void push(int e){
            arr[back++] = e;
            size++;
        }
        public int pop(){
            if (isEmpty() == 1) return -1;
            size--;
            int e = arr[front++];
            return e;
        }

        public int size(){
            return size;
        }

        public int front(){
            if (isEmpty() == 1) return -1;
            return arr[front];
        }

        public int back(){
            if (isEmpty() == 1) return -1;
            if (back - 1 < 0) return -1;
            return arr[back-1];
        }

        public int isEmpty(){
            return front == back ? 1 : 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        Queue queue = new Queue();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("push")){
                int e = Integer.parseInt(st.nextToken());
                queue.push(e);
            }else if (command.equals("pop")){
                sb.append(queue.pop()).append("\n");
//                bw.write(queue.pop());
            }else if (command.equals("front")){
                sb.append(queue.front()).append("\n");
//                bw.write(queue.front());
            }else if (command.equals("back")){
                sb.append(queue.back()).append("\n");
//                bw.write(queue.back());
            }else if (command.equals("empty")){
                sb.append(queue.isEmpty()).append("\n");
//                bw.write(queue.isEmpty());
            }else {
                sb.append(queue.size()).append("\n");
//                bw.write(queue.size());
            }
//            bw.write("\n");
        }
        System.out.println(sb);
    }
}
