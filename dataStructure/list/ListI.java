package datastructure.list;

public interface ListI<E> {

    void addFirst(E obj);
    void addLast(E obj);
    E removeFirst();
    E removeLast();
    boolean contains(E obj);
    E remove(E obj);
    E peekFirst();
    E peekLast();
}
