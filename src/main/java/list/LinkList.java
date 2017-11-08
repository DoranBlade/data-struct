package list;

import exception.OutBoundException;
import model.Node;
import model.Person;

/**
 * 链式结构的线性表
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
        length = 0;
    }

    @Override
    public Person get(int index) throws OutBoundException {
        if (index >= length) {
            throw new OutBoundException();
        }
        Node result = first;
        for (int i = 0; i <= index; i++) {
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
        Node previousNode = grow(index);
        Node currentNode = new Node(person);
        currentNode.setNext(previousNode.getNext());
        previousNode.setNext(currentNode);
        length++;
    }

    @Override
    public void put(int index, Person person) throws OutBoundException {
        if (index >= length) {
            throw new OutBoundException();
        }
        Node result = first;
        for (int i = 0; i <= index; i++) {
            result = result.getNext();
        }
        result.setValue(person);
    }

    @Override
    public Person delete(int index) throws OutBoundException {
        if (index >= length) {
            throw new OutBoundException();
        }
        // 定位所删除元素的前节点
        Node previousNode = first;
        for (int i = 0; i < index; i++) {
            previousNode = previousNode.getNext();
        }
        // 要删除的节点脱离链表，等待jvm回收
        Node deleteNode = previousNode.getNext();
        previousNode.setNext(deleteNode.getNext());
        length--;
        return deleteNode.getValue();
    }

    @Override
    public int length() {
        return length;
    }

    /**
     * 判断是否需要扩容，如果需要扩容则扩容到指定大小
     * @param index 需要插入的位置
     * @return 需要插入节点的前节点
     */
    private Node grow(int index) {
        // 在现有长度下不需要扩容
        Node currentNode = first;
        if (index <= length) {
            for (int i = 0; i < index; i++)  {
                currentNode = currentNode.getNext();
            }
            return currentNode;
        }

        // 需要填充空元素扩容
        for (int i = 0; i < index; i++) {
            if (i >= length) {
                currentNode.setNext(Node.empty());
                length++;
            }
            currentNode = currentNode.getNext();
        }
        return currentNode;
    }
}
