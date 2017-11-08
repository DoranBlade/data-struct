package Queue;

import exception.OutBoundException;
import model.Person;

/**
 * Created by eric on 17-11-8
 */
public class ArrayQueue implements Queue {

    private static final int default_length = 0;
    private static final int default_capacity = 10;

    private int length;
    private Person[] container;

    public ArrayQueue() {
        this.length = default_length;
        this.container = new Person[default_capacity];
    }

    @Override
    public void clear() {
        if (isEmpty()) {
            return;
        }
        for (int i = 0; i < length; i++) {
            container[i] = null;
        }
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
        return container[default_length];
    }

    @Override
    public Person deQueue() throws OutBoundException {
        if (isEmpty()) {
            throw new OutBoundException();
        }
        // 第二个元素开始，向前移动
        Person result = container[default_capacity];
        int index = default_capacity;
        for (; index < length - 1; index++) {
            container[index] = container[index + 1];
        }
        container[index] = null;
        length--;
        return result;
    }

    @Override
    public void enQueue(Person person) {
        grow();
        container[length] = person;
        length++;
    }

    private void grow() {
        if (length == container.length + 1) {
            int newCapacity = container.length * 2;
            Person[] newContainer = new Person[newCapacity];
            for (int i = 0; i < container.length; i++) {
                newContainer[i] = container[i];
            }
            container = newContainer;
        }
    }
}
