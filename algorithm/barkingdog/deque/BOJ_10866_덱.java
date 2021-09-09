package algorithm.barkingdog.deque;

import java.util.StringTokenizer;
import java.io.*;

class Deque {
    private final int MX = 100001;
    private int[] dat = new int[2 * MX + 1];
    private int size;
    private int head = MX, tail = MX;

    void push_front(int e) {
        dat[--head] = e;
        size++;
    }

    void push_back(int e) {
        dat[tail++] = e;
        size++;
    }

    int pop_front() {
        if (head == tail) return -1;
        size--;
        return dat[head++];
    }

    int pop_back() {
        if (head == tail) return -1;
        size--;
        return dat[--tail];
    }

    int front() {
        if (head == tail) return -1;
        return dat[head];
    }

    int back() {
        if (head == tail) return -1;
        return dat[tail - 1];
    }

    int isEmpty() {
        if (size() == 0)
            return 1;
        return 0;
    }

    int size() {
        return size;
    }

}

public class BOJ_10866_덱 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Deque deque = new Deque();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if (cmd.equals("front")) {
//                System.out.println(deque.front());
                bw.write(deque.front() + "\n");
            } else if (cmd.equals("back")) {
//                System.out.println(deque.back());
                bw.write(deque.back() + "\n");
            } else if (cmd.equals("size")) {
//                System.out.println(deque.size());
                bw.write(deque.size() + "\n");
            } else if (cmd.equals("empty")) {
//                System.out.println(deque.isEmpty());
                bw.write(deque.isEmpty() + "\n");
            } else if (cmd.equals("pop_front")) {
//                System.out.println(deque.pop_front());
                bw.write(deque.pop_front() + "\n");
            } else if (cmd.equals("pop_back")) {
//                System.out.println(deque.pop_back());
                bw.write(deque.pop_back() + "\n");
            } else {
                int element = Integer.parseInt(st.nextToken());
                if (cmd.equals("push_back")) {
                    deque.push_back(element);
                } else {
                    deque.push_front(element);
                }
            }

        }
        bw.flush();
    }
}