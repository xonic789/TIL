package dataStructure.hash;


import dataStructure.list.LinkedList;

import java.util.Iterator;

public class Hash<K,V> implements HashI<K,V>,Iterable{

    @Override
    public Iterator iterator() {
        return new IteratorHelper();
    }

    class IteratorHelper<T> implements Iterator<T>{
        T[] keys;
        int position;

        public IteratorHelper(){
            this.keys = (T[]) new Object[numElements];
            int p = 0;
            // Hash의 hashArray 모든 요소를 꺼내는 과정
            for (int i = 0; i < tableSize; i++){
                LinkedList<HashElement<K,V>> list = hashArray[i];
                // LinkedList 의 요소인 HashElement 를 꺼내는 과정
                // LinkedList 에 정의돼 있는 Iterator 를 이용함.
                for (HashElement<K,V> h : list){
                    keys[p++] = (T) h.key;
                }
                position = 0;
            }
        }

        @Override
        public boolean hasNext() {
            return position < keys.length;
        }

        @Override
        public T next() {
            if (!hasNext()){
                return null;
            }
            return keys[position++];
        }
    }

    class HashElement<K,V> implements Comparable<HashElement<K,V>>{
        K key;
        V value;
        public HashElement(K key, V value){
            this.key = key;
            this.value = value;
        }

        @Override
        public int compareTo(HashElement<K, V> o) {
            return (((Comparable<K>)o.key)).compareTo(this.key);
        }
    }
    //요소의 개수, 배열의 크기

    private int numElements,tableSize;
    private double maxLoadFactor;
    private LinkedList<HashElement<K,V>>[] hashArray;

    public Hash(int tableSize){
        this.tableSize = tableSize;
        hashArray = (LinkedList<HashElement<K,V>>[]) new LinkedList[tableSize];
        // 빈 LinkedList 로 초기화 해주는 과정
        // 매 번 hashcode 를 통해 LinkedList 를 확인해주는 과정 생략 가능
        for (int i = 0; i < tableSize; i++)
            hashArray[i] = new LinkedList<>();

        maxLoadFactor = 0.75;
        numElements = 0;
    }

    public boolean add(K key, V value){
        if (loadFactor() > maxLoadFactor)
            resize(tableSize*2);
        HashElement<K,V> hashElement = new HashElement<>(key, value);

        int hashVal = hashcode(key);

        hashArray[hashVal].addLast(hashElement);
        numElements++;
        return true;
    }
    
    // remove 구현하기
    public boolean remove(K key, V value){
        int hashVal = hashcode(key);
        HashElement<K,V> hashElements = hashArray[hashVal].remove(new HashElement<>(key,value));
        numElements--;
        return hashElements != null ? true : false;
    }

    public V getValue(K key){
        int hashVal = this.hashcode(key);
        for (HashElement<K,V> he: hashArray[hashVal]){
            if (((Comparable<K>)key).compareTo(he.key) == 0){
                return he.value;
            }
        }
        return null;
    }

    private double loadFactor(){
        double cnt = 0;

        for (LinkedList list : hashArray){
            if (list.getHead() != null) {
                cnt++;
            }
        }

        return cnt / tableSize;
    }

    private int hashcode(K key){
        int hashVal = key.hashCode();
        hashVal = hashVal % 0x7FFFFFFF;
        hashVal = hashVal % tableSize;
        return hashVal;
    }

    public void resize(int tableSize){
        LinkedList<HashElement<K,V>>[] new_array = (LinkedList<HashElement<K,V>>[]) new LinkedList[tableSize];
        for (int i = 0; i < tableSize; i++){
            new_array[i] = new LinkedList<>();
        }
        this.tableSize = tableSize;
        for (LinkedList<HashElement<K,V>> li : hashArray){
            for (HashElement<K,V> he : li){
                if (li.getHead() != null){
                    int hashVal = hashcode(he.key);
                    new_array[hashVal].addLast(he);
                }
            }
        }
        hashArray = new_array;
    }

    public int getTableSize() {
        return tableSize;
    }

    public int getNumElements() {
        return numElements;
    }

    public double getMaxLoadFactor() {
        return maxLoadFactor;
    }

    public LinkedList<HashElement<K, V>>[] getHashArray() {
        return hashArray;
    }
}
