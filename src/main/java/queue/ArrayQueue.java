package queue;

/**
 * Created by eric on 17-11-8
 */
public class ArrayQueue<T> implements Queue<T> {

    private static final int default_length = 0;
    private static final int default_capacity = 10;

    private int length;
    private Object[] container;

    public ArrayQueue() {
        this.length = default_length;
        this.container = new Object[default_capacity];
    }

    @Override
    public void clear() {
        container = new Object[default_capacity];
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
        return (T) container[default_length];
    }

    @Override
    public T deQueue() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        // 第二个元素开始，向前移动
        T result = (T) container[default_length];
        int index = default_length;
        for (; index < length - 1; index++) {
            container[index] = container[index + 1];
        }
        container[index] = null;
        length--;
        return result;
    }

    @Override
    public void enQueue(T t) {
        grow();
        container[length] = t;
        length++;
    }

    private void grow() {
        if (length == container.length + 1) {
            int newCapacity = container.length * 2;
            Object[] newContainer = new Object[newCapacity];
            for (int i = 0; i < container.length; i++) {
                newContainer[i] = container[i];
            }
            container = newContainer;
        }
    }
}
