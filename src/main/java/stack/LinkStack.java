package stack;

import exception.OutBoundException;
import model.Node;
import model.Person;

/**
 * 链式结构的栈
 * Created by eric on 17-11-8
 */
public class LinkStack implements Stack {

    private static final int default_length = -1;

    private int top;

    private Node first;


    public LinkStack() {
        this.top = default_length;
        this.first = Node.empty();
    }

    @Override
    public void clear() {
        if (isEmpty()) {
            return;
        }
        first.setNext(null);
        top = default_length;
    }

    @Override
    public boolean isEmpty() {
        return top == default_length;
    }

    @Override
    public Person get() throws OutBoundException {
        if (isEmpty()) {
            throw new OutBoundException();
        }
        Node result = range(top);
        return result.getValue();
    }

    @Override
    public void push(Person person) {
        Node currentNode = new Node(person);
        Node lastNode = range(top);
        lastNode.setNext(currentNode);
        top++;
    }

    @Override
    public Person pop() throws OutBoundException {
        if(isEmpty()) {
            throw new OutBoundException();
        }
        Node previousNode = range(--top);
        Node result = previousNode.getNext();
        previousNode.setNext(null);
        return result.getValue();
    }

    @Override
    public int length() {
        return top + 1;
    }

    /**
     * 获取指定索引的节点
     * @param length 指定索引
     * @return 指定索引的节点
     */
    private Node range(int length) {
        Node result = first;
        for (int i = 0; i <= length; i++) {
            result = result.getNext();
        }
        return result;
    }
}
