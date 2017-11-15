package tree;

import model.Person;

import java.util.LinkedList;
import java.util.List;

/**
 * 树形结构
 * Created by eric on 17-11-15
 */
public class Node {

    // 节点的值
    private Person value;
    // 子节点集合,暂时使用Java实现的链式结构
    private List<Node> children;

    public Node() {
        this.children = new LinkedList<>();
    }

    public Node(Person value) {
        this();
        this.value = value;
    }

    public Person get() {
        return this.value;
    }

    public Node find(int index) {
        return this.children.get(index);
    }

    public void clear() {
        this.children.clear();
    }
}
