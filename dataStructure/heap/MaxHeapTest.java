package dataStructure.heap;

public class MaxHeapTest {

    public static void main(String[] args) {
        BinaryHeap<Integer> bh = new BinaryHeap<>(15);

        for (int i = 0; i < 15; i++){
            bh.add(i);
            System.out.println(bh.getLastPosition());
        }
        System.out.println(bh.toString());

        for (int i = 0; i < 16; i++){
            System.out.println(bh.remove());
        }
        System.out.println(bh.toString());



    }
}
