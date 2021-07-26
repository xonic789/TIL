package algorithm;

class Node{
    int data;
    Node lt,rt;
    public Node(int val){
        data = val;
        lt=rt=null;
    }
}


public class BinaryTreeDFS {
    Node root;
    public void DFS(Node root){
        if (root == null) return;
        else {
            System.out.print(root.data + " ");
            DFS(root.lt);
            DFS(root.rt);
        }
    }
 

    public static void main(String[] args) {
        BinaryTreeDFS binaryTreeDFS = new BinaryTreeDFS();
        binaryTreeDFS.root = new Node(1);
        binaryTreeDFS.root.lt = new Node(2);
        binaryTreeDFS.root.rt = new Node(3);
        binaryTreeDFS.root.lt.lt = new Node(4);
        binaryTreeDFS.root.lt.rt = new Node(5);
        binaryTreeDFS.root.rt.lt = new Node(6);
        binaryTreeDFS.root.rt.rt = new Node(7);
        binaryTreeDFS.DFS(binaryTreeDFS.root) ;
    }

}
