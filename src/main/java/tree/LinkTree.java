package tree;

import model.Person;

/**
 * 链式存储结构
 * Created by eric on 17-11-9
 */
public class LinkTree implements Tree {

    private static final int default_depth = 1;

    // 根节点
    private Node root;

    // 树的深度
    private int depth;

    public LinkTree() {
        this.root = new Node();
        this.depth = default_depth;
    }

    @Override
    public void clear() {
        if (isEmpty()) {
            return;
        }
        this.root.clear();
    }

    @Override
    public boolean isEmpty() {
        return this.depth == default_depth;
    }

    @Override
    public int depth() {
        return this.depth;
    }

    @Override
    public Node root() {
        return root;
    }

    @Override
    public Person value(Node node) {
        return null;
    }

    @Override
    public void assign(Node node, Person value) {

    }

    @Override
    public Node parent(Node child) {
        return null;
    }

    @Override
    public Node leftChild(Node node) {
        return null;
    }

    @Override
    public Node rightSlibing(Node node) {
        return null;
    }

    @Override
    public void insertChild(Node parent, Node children) {

    }

    @Override
    public void deleteChild(Node parent, int index) {

    }

    /**
     * 检查树中是否存在node节点
     */
    private boolean isExits(Node node) {
        return false;
    }
}
