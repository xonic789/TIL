package dataStructure;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<E> implements ListI<E>,Iterable<E>{


    @Override
    public Iterator iterator() {
        return new IteratorHelper();
    }

    class IteratorHelper implements Iterator<E>{

        Node<E> index;
        public IteratorHelper(){
            index = head;
        }

        @Override
        public boolean hasNext() {
            return index != null;
        }

        @Override
        public E next() {
            if (!hasNext()){
                throw new NoSuchElementException();
            }
            E val = index.data;
            index = index.next;
            return val;
        }
    }


    class Node<E>{
        E data;
        Node<E> next;
        public Node(E obj){
            this.data = obj;
            this.next = null;
        }
    }



    private Node<E> head;
    private Node<E> tail;
    private int currentSize;
    public LinkedList(){
        this.head = null;
        currentSize = 0;
    }

    // 맨 앞에 추가할 때
    public void addFirst(E obj){
        Node<E> node = new Node<E>(obj);
        if (head == null){
            head = tail = node;
            currentSize++;
            return;
        }
        node.next = head;
        head = node;
        currentSize++;
    }

    // 맨 뒤에 추가할 때
    public void addLast(E obj){
        Node<E> node = new Node<E>(obj);
        // 요소가 비어 있을 때
        if (head == null){
            head = tail = node;
            currentSize++;
            return;
        }
        // O(n) 방식
/*        Node<E> tmp = head;
        // next 포인터가 null일 때까지 tmp를 갱신한다.
        while (tmp.next != null){
            tmp = tmp.next;
        }
        tmp.next = node;*/
        tail.next = node;
        tail = node;
        currentSize++;
    }

    public E removeFirst(){
        if (head == null){
            return null;
        }
        // head와 tail의 포인터가 같을시
        // 요소가 한개 있다는 말이 되므로
        // head와 tail을 null로 초기화한다.
        Node<E> tmp = head;
        if (head == tail)
            head = tail = null;
        else
            head = head.next;

        currentSize--;
        return tmp.data;
    }

    public E removeLast(){
        if (head == null){
            return null;
        }
        // current
        // previous
        if (head == tail)
            return removeFirst();
        Node<E> current = head;
        Node<E> previous = null;

        // tail과 current 포인터가 같으면
        // current는 tail과 같고,
        // previous는 이 전 노드를 가리키게 됨.
        while (tail != current) {
            previous = current;
            current = current.next;
        }

        // tail까지 왔으면, tail 이전 previous.next를 null
        // garbage collector 가 제어해준다.
        previous.next = null;
        tail = previous;
        currentSize--;
        return current.data;
    }

    public E remove(E obj){
        if (head == null){
            return null;
        }
        Node<E> current = head, previous = null;
        // head 부터 current 가 null 일 때까지 반복하여
        while (current != null){
            // 매 번 두 객체를 비교하여, argument obj 와 current.data를 비교했을 때
            // compareTo가 0을 retturn 한다면, 요소가 같다는 것이기 때문에
            // head 와 tail pointer 를 비교하여 바로 삭제한다.
            if (contains(obj)){
                // current 가 head 와 pointer 가 같다면,
                if (current == head){
                    return removeFirst();
                }
                // current 가 tail 과 같다면,
                if (current == tail){
                    return removeLast();
                }
                // 만약 head 와 tail 이 아니라면,
                // current.next 를 previous.next 포인터에 참조 시킨다.
                // 원래 previous.next 가 가리키고 있던 current 는
                // garbage collector 가 처리한다.
                currentSize--;
                previous.next = current.next;
                return current.data;
            }
            // previous 에 current 를 참조시키고,
            // current 는 current.next 를 참조한다.
            previous = current;
            current = current.next;
        }

        return null;
    }

    public boolean contains(E obj){
        Node<E> current = head;
        while (current != null){
            if (((Comparable<E>)obj).compareTo(current.data) == 0){
                return true;
            }
        }
        return false;
    }

    public E peekFirst(){
        if (head == null){
            return null;
        }
        return head.data;
    }

    public E peekLast(){
        if (tail == null){
            return null;
        }
        return tail.data;
    }

    public Node<E> getHead() {
        return head;
    }

    public Node<E> getTail() {
        return tail;
    }

    public String toString(){
        Node<E> tmp = head;
        String s = "";
        while (tmp.next != null){
            s += tmp.data + " ";
            tmp = tmp.next;
        }
        s += tmp.data;
        return s;
    }

}
