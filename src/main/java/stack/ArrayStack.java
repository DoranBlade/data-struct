package stack;

import exception.OutBoundException;
import model.Person;

/**
 * 顺序结构的栈结构
 * Created by eric on 17-11-8
 */
public class ArrayStack implements Stack {

    private static final int default_length = -1;
    private static final int default_size = 10;

    private int top;

    private Person[] container;

    public ArrayStack() {
        this.top = default_length;
        this.container = new Person[default_size];
    }


    @Override
    public void clear() {
        if (isEmpty()) {
            return;
        }
        for (int i = 0; i <= top; i++) {
            container[i] = null;
        }
        top = default_length;
    }

    @Override
    public boolean isEmpty() {
        return top == default_length;
    }

    @Override
    public Person get() throws OutBoundException {
        if (isEmpty()) {
            throw  new OutBoundException();
        }
        return container[top];
    }

    @Override
    public void push(Person person) {
        grow();
        top++;
        container[top] = person;
    }

    @Override
    public Person pop() throws OutBoundException {
        if (isEmpty()) {
            throw  new OutBoundException();
        }
        Person result = container[top];
        container[top] = null;
        top--;
        return result;
    }

    @Override
    public int length() {
        return top + 1;
    }

    /**
     * 判断是否需要扩容
     */
    private void grow() {
        if (top >= container.length - 1) {
            int newCapacity = container.length * 2;
            Person[] newContainer = new Person[newCapacity];
            for (int i = 0; i < container.length; i++) {
                newContainer[i] = container[i];
            }
            container = newContainer;
        }
    }
}
