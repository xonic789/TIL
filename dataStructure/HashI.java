package dataStructure;

public interface HashI<K, V> {

    boolean add(K key, V value);
    void resize(int tableSize);

}
