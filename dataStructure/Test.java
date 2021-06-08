package dataStructure;

public class Test {

    public static void main(String[] args) {

        ListI<Integer> list = new LinkedList<>();
        int n = 10;

        for (int i = 0; i < n; i++){
            list.addFirst(i);
        }

        System.out.println(list.toString());
        System.out.println(list.removeFirst());
        System.out.println(list.removeFirst());
        System.out.println(list.toString());
        System.out.println(list.removeLast());
        System.out.println(list.removeLast());
        System.out.println(list.toString());

    }
}
