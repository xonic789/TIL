package dataStructure.hash;

public class HashTest {

    public static void main(String[] args) {

        Hash hash = new Hash(13);

        for (int i = 0; i < 13; i++){
            hash.add(String.valueOf(i),"헤위");
        }

        for (Object key : hash){
            System.out.println("Key " + key + " value " + hash.getValue(key));
        }

    }
}
