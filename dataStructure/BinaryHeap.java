package dataStructure;

public class BinaryHeap<E> {
    private int lastPosition;
    private E[] array;

    public BinaryHeap(int size){
        this.lastPosition = 0;
        array = (E[]) new Object[size];
    }


    public void add(E obj){
        array[lastPosition + 1] = obj;
        trickleUp(lastPosition);
        lastPosition++;
    }

    private void trickleUp(int position) {
        if (position == 0){
            return;
        }
        // 부모 인덱스를 찾는 과정.
        int parent = (int) Math.floor((position - 1) / 2);
        if (array[parent] == null || ((Comparable<E>)array[position]).compareTo(array[parent]) > 0){
            swap(position,parent);
            trickleUp(parent);
        }
    }

    public E remove(){
        E tmp = array[0];
        // root 를 지울 때, lastPosition-- 을 통해서 더 이상 힙에 속하지 않게 한다.
        swap(0,lastPosition--);
        trickleDown(0);
        return tmp;
    }

    private void trickleDown(int parent) {
        int left = 2 * parent + 1;
        int right = 2 * parent + 2;

        // 부모 노드가 자식 노드보다 큰 경우와 left 가 lastPosition 와 같을 때,
        // recursion's base case 이며, max binary heap 의 조건을 만족할 때
        // array[parent] 가 array[left] 보다 클 경우
        if (left == lastPosition && ((Comparable<E>)array[parent]).compareTo(array[left]) < 0){
            swap(parent,left);
            return;
        }
        if (right == lastPosition && ((Comparable<E>)array[parent]).compareTo(array[right]) < 0){
            swap(parent,right);
            return;
        }
        // 함수가 max binary heap 의 규칙을 충족하며 left , right 가 lastposition 보다 크거나 같으면,
        // 함수를 종료한다.
        if (left >= lastPosition || right >= lastPosition){
            return;
        }
        // array[left] > array[right] && array[parent] < array[left]
        // left 의 값이 parent 값과 right 의 값보다 크다면
        if (((Comparable<E>)array[left]).compareTo(array[right]) > 0
                && ((Comparable<E>)array[parent]).compareTo(array[left]) < 0){
            swap(parent,left);
            trickleDown(left);
        }else if(((Comparable<E>)array[right]).compareTo(array[left]) > 0
                && ((Comparable<E>)array[parent]).compareTo(array[right]) < 0){
            swap(parent,right);
            trickleDown(right);
        }

    }

    private void swap(int from, int to){
        E tmp = array[from];
        array[from] = array[to];
        array[to] = tmp;
    }

    public String toString(){
        String s = "[";

        for (E a : array){
            s += a + ",";
        }
        String substring = s.substring(0, s.length() - 1);

        substring += "]";

        return substring;
    }

    public int getLastPosition() {
        return this.lastPosition;
    }
}
