package dataStructure;

public class HashTest {

    public static void main(String[] args) {

        Hash hash = new Hash(13);

        for (int i = 0; i < 13; i++){
            hash.add(String.valueOf(i),i);
            System.out.println(hash.getTableSize());
            System.out.println(hash.getValue(String.valueOf(i)));
        }

        for (int i = 0; i < 26; i++){
            System.out.println(hash.getValue(String.valueOf(i)));
        }

        hash.add("ab",1);
        hash.add("ba",2);


        System.out.println(hash.getValue("ab"));
        System.out.println(hash.getValue("ba"));


    }
}
