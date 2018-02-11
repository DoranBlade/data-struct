package stack;

/**
 * 顺序结构的栈结构
 * Created by eric on 17-11-8
 */
public class ArrayStack<T> implements Stack<T> {

    private static final int default_length = -1;
    private static final int default_size = 10;

    private int top;

    private Object[] container;

    public ArrayStack() {
        this.top = default_length;
        this.container = new Object[default_size];
    }


    @Override
    public void clear() {
        container = new Object[default_size];
        top = default_length;
    }

    @Override
    public boolean isEmpty() {
        return top == default_length;
    }

    @Override
    public T get() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        return (T) container[top];
    }

    @Override
    public void push(T t) {
        grow();
        top++;
        container[top] = t;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        T result = (T) container[top];
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
            Object[] newContainer = new Object[newCapacity];
            for (int i = 0; i < container.length; i++) {
                newContainer[i] = container[i];
            }
            container = newContainer;
        }
    }
}
