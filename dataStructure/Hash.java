package dataStructure;

public class Hash<K,V> implements HashI<K,V>{

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
    int numElements,tableSize;
    double maxLoadFactor;
    LinkedList<HashElement<K,V>>[] hashArray;

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
    public boolean remove(K key){
        int hashVal = hashcode(key);

    }

    public double loadFactor(){
        int cnt = 0;

        for (LinkedList list : hashArray){
            if (list.getHead() != null){
                cnt++;
            }
        }

        return tableSize / cnt;
    }

    private int hashcode(K key){
        int hashVal = key.hashCode();
        hashVal = hashVal % 0x7FFFFFFF;
        hashVal = hashVal % tableSize;
        return hashVal;
    }

    public void resize(int tableSize){

    }

}
