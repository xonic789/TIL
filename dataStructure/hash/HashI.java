package dataStructure.hash;

public interface HashI<K, V> {

    boolean add(K key, V value);
    void resize(int tableSize);
    boolean remove(K key, V value);
    V getValue(K key);

}
