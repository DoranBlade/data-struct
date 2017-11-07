package list;

import exception.OutBoundException;
import model.Person;

/**
 * 链式存储结构的线性表
 * Created by eric on 17-11-7
 */
public class LinkList implements List {

    private static final int default_length = 0;

    private int length;
    private Node first;

    public LinkList() {
        this.length = default_length;
        this.first = new Node();
    }

    @Override
    public boolean isEmpty() {
        return length <= 0;
    }

    @Override
    public void clear() {
        first.setNext(null);
    }

    @Override
    public Person get(int index) throws OutBoundException {
        if (index >= length) {
            throw new OutBoundException();
        }
        Node result = first;
        for (int i = 0; i < length; i++) {
            result = result.getNext();
        }
        return result.getValue();
    }

    @Override
    public int find(Person person) {
        Node result = first;
        for (int i = 0; i < length; i++) {
            result = result.getNext();
            if (result.getValue().equals(person)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void insert(int index, Person person) {

    }

    @Override
    public void put(int index, Person person) throws OutBoundException {
        if (index >= length) {
            throw new OutBoundException();
        }
        Node result = first;
        for (int i = 0; i < length; i++) {
            result = result.getNext();
        }
        result.setValue(person);
    }

    @Override
    public Person delete(int index) {
        return null;
    }

    @Override
    public int length() {
        return length;
    }
}
