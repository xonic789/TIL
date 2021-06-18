package algorithm;


import java.util.LinkedList;
import java.util.Queue;

public class Bfs {
    Node root;

    public void BFS(Node root){
        Queue<Node> Q = new LinkedList<>();
        Q.offer(root);
        int L = 0;
        while (!Q.isEmpty()){
            int len = Q.size();
            System.out.print(L + " : ");
            for (int i = 0; i < len; i++){
                Node current = Q.poll();
                System.out.print(current.data + " ");
                if (current.lt != null)
                    Q.offer(current.lt);
                if (current.rt != null)
                    Q.offer(current.rt);
            }
            L++;
            System.out.println();
        }

    }


    public static void main(String[] args) {
        Bfs bfs = new Bfs();
        bfs.root = new Node(1);
        bfs.root.lt = new Node(2);
        bfs.root.rt = new Node(3);
        bfs.root.lt.lt = new Node(4);
        bfs.root.lt.rt = new Node(5);
        bfs.root.rt.lt = new Node(6);
        bfs.root.rt.rt = new Node(7);
        bfs.BFS(bfs.root);
    }
}
