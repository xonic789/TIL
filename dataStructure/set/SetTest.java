package datastructure.set;

public class SetTest {

    public static void main(String[] args) {
        int[] array = {1,1,1,2,3,4,5,5,7,1,2,3,4,5,6,10,2,1,3,4,5,5,1,6,57,4,1,2394};

        Set set = new Set(array);
        set.add(1254);
        set.add(24);
        set.add(25);
        set.add(26);
        set.add(27);
        set.add(287);
        set.add(15);
        set.add(656);
        set.add(1254);
        set.add(1254);
        set.remove(1);

        System.out.println(set);
    }
}
