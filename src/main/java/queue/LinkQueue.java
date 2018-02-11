package queue;

import model.Node;

/**
 * Created by eric on 17-11-8
 */
public class LinkQueue<T> implements Queue<T> {

    private static final int default_length = 0;

    private int length;
    private Node<T> first;

    public LinkQueue() {
        this.length = default_length;
        this.first = new Node<>();
    }


    @Override
    public void clear() {
        first.setNext(null);
        length = default_length;
    }

    @Override
    public boolean isEmpty() {
        return length == default_length;
    }

    @Override
    public int length() {
        return length;
    }

    @Override
    public T get() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        return first.getNext().getValue();
    }

    @Override
    public T deQueue() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> currentNode = first.getNext();
        first.setNext(currentNode.getNext());
        length--;
        return currentNode.getValue();
    }

    @Override
    public void enQueue(T t) {
        Node<T> currentNode = first;
        for (int i = 0; i < length; i++) {
            currentNode = currentNode.getNext();
        }
        currentNode.setNext(new Node<>(t));
        length++;
    }
}
