package stack;

import model.Node;

/**
 * 链式结构的栈
 * Created by eric on 17-11-8
 */
public class LinkStack<T> implements Stack<T> {

    private static final int default_length = -1;

    private int top;

    private Node<T> first;


    public LinkStack() {
        this.top = default_length;
        this.first = new Node<>();
    }

    @Override
    public void clear() {
        first.setNext(null);
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
        Node<T> result = range(top);
        return result.getValue();
    }

    @Override
    public void push(T t) {
        Node<T> currentNode = new Node<>(t);
        Node<T> lastNode = range(top);
        lastNode.setNext(currentNode);
        top++;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> previousNode = range(--top);
        Node<T> result = previousNode.getNext();
        previousNode.setNext(null);
        return result.getValue();
    }

    @Override
    public int length() {
        return top + 1;
    }

    /**
     * 获取指定索引的节点
     *
     * @param length 指定索引
     * @return 指定索引的节点
     */
    private Node<T> range(int length) {
        Node<T> result = first;
        for (int i = 0; i <= length; i++) {
            result = result.getNext();
        }
        return result;
    }
}
