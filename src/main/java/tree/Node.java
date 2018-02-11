package tree;

import java.util.LinkedList;
import java.util.List;

/**
 * 树形结构
 * Created by eric on 17-11-15
 */
public class Node<T> {

    // 节点的值
    private T value;
    // 子节点集合,暂时使用Java实现的链式结构
    private List<Node<T>> children;
    // 父节点
    private Node<T> parent;

    public Node() {
        this.children = new LinkedList<>();
    }

    public Node(T t) {
        this();
        this.value = t;
    }

    public boolean isEmpty() {
        return getValue() == null;
    }

    public T getValue() {
        return this.value;
    }

    public void setValue(T t) {
        this.value = t;
    }

    public List<Node<T>> getChildren() {
        return children;
    }

    public void setChildren(List<Node<T>> children) {
        this.children = children;
    }

    public Node<T> getParent() {
        return parent;
    }

    public void setParent(Node<T> parent) {
        this.parent = parent;
    }

    public Node<T> find(int index) {
        return this.children.get(index);
    }

    /**
     * 清空当前节点的value和children节点
     */
    public void clear() {
        this.value = null;
        this.children.clear();
    }
}
