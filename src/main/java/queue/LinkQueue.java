package queue;

import exception.OutBoundException;
import model.Node;
import model.Person;

/**
 * Created by eric on 17-11-8
 */
public class LinkQueue implements Queue {

    private static final int default_length = 0;

    private int length;
    private Node first;

    public LinkQueue() {
        this.length = default_length;
        this.first = Node.empty();
    }


    @Override
    public void clear() {
        if (isEmpty()) {
            return;
        }
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
    public Person get() throws OutBoundException {
        if (isEmpty()) {
            throw new OutBoundException();
        }
        return first.getNext().getValue();
    }

    @Override
    public Person deQueue() throws OutBoundException {
        if (isEmpty()) {
            throw new OutBoundException();
        }
        Node currentNode = first.getNext();
        first.setNext(currentNode.getNext());
        length--;
        return currentNode.getValue();
    }

    @Override
    public void enQueue(Person person) {
        Node currentNode = first;
        for (int i = 0; i < length; i++) {
            currentNode = currentNode.getNext();
        }
        currentNode.setNext(new Node(person));
        length++;
    }
}
