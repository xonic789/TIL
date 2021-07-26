package algorithm.inflearn.tree;

class Node{
    int data;
    Node lt,rt;
    public Node(int val){
        data = val;
        lt = rt = null;
    }
}

public class 말단노드DFS {
    static Node root;
    static int DFS(int L, Node root){
        if (root.lt == null && root.rt == null) return L;
        else return Math.min(DFS(L+1,root.lt), DFS(L+1,root.rt));
    }

    public static void main(String[] args) {
        말단노드DFS.root = new Node(1);
        말단노드DFS.root.lt = new Node(2);
        말단노드DFS.root.rt = new Node(3);
        말단노드DFS.root.lt.lt = new Node(4);
        말단노드DFS.root.lt.rt = new Node(5);
        System.out.println(DFS(0, 말단노드DFS.root));
    }
}
