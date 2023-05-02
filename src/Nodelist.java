package link;

import org.w3c.dom.Node;

import static jdk.internal.util.Preconditions.checkIndex;

public class Nodelist<E> {
    Node first;
    int size = 0;

    public Nodelist() {
        first = null;

    }

    public void insertFirst(E data) {
        Node newNode = new Node(data);
        newNode.next = first;
        first = newNode;
        size++;

    }

    public void deleteFirst() {
        first = first.next;
        size--;
    }

    boolean inserterlast(E data) {
        if (first == null) {
            insertFirst(data);
        } else {
            Node current = first;
            while (current.next != null) {
                current = current.next;
            }
            Node newNode = new Node(data);
            current.next = newNode;
            size++;
        }

    }

    void deleteAfter(Node after) {
        Node current = first;
        while (current.data != after.data) {
            current = current.next;
        }
        current.next = current.next.next;
        size--;
    }

    void add(E data) {
        inserterlast(data);
        return true;
    }

    int size() {
        return size;
    }

    public E get(int index) {
        checkIndex(index.data);
        return node(index).data;
    }

    void remove(int index) {
        Node current = first;
        Node previous = first;
        for (int i = 0; i <= index ; i++) {

            if(i==index){
                break;
            }
            previous = current;
            current= current.next;
        }
        if(current==first) {
            first = first.next;
            size--;
        }else {
            previous.next = current.next;
            size--;
        }
    }

    Node<E> node(int index) {
        Node current = first;
        for (int i = 0; i <= index; i++) {
            if (i == index) {
                break;
            }
            current = current.next;
        }
        return current;
    }
    void checkIndex(int index){
        if (index >= size || index<0 ){
            throw new IndexOutOfBoundsException("index"+ index+"out of bounds for length"+size);

        }
    }
}