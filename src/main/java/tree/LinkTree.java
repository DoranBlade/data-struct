package tree;

import model.Person;

/**
 * 链式存储结构
 * Created by eric on 17-11-9
 */
public class LinkTree<T> implements Tree<T> {

    // 根节点
    private Node<T> root;

    public LinkTree(T t) {
        this.root = new Node<>(t);
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
        return root().isEmpty();
    }

    @Override
    public Node<T> root() {
        return root;
    }

    @Override
    public T value(Node<T> node) {
        return node.getValue();
    }

    @Override
    public void assign(Node<T> node, T value) {
        node.setValue(value);
    }

    @Override
    public Node<T> parent(Node<T> child) {
        return child.getParent();
    }

    @Override
    public Node<T> leftChild(Node<T> node) {
        return node.find(0);
    }

    @Override
    public Node<T> rightSibling(Node<T> node) {
        Node<T> parent = node.getParent();
        int currentIndex = parent.getChildren().indexOf(node);
        if (currentIndex < parent.getChildren().size() - 1) {
            return parent.find(++currentIndex);
        }
        return null;
    }

    @Override
    public void insertChild(Node<T> parent, Node<T> children) {
        children.setParent(parent);
        parent.getChildren().add(children);
    }

    @Override
    public void deleteChild(Node<T> parent, int index) {
        parent.getChildren().remove(index);
    }

    /**
     * 检查树中是否存在node节点
     */
    @Override
    public boolean isExist(Node<T> node) {
        return isExist(this.root, node);
    }

    /**
     * 判断targetNode是否与sourceNode节点是否相同
     */
    private boolean isExist(Node<T> sourceNode, Node<T> targetNode) {
        if (sourceNode == targetNode) {
            return true;
        }
        for (Node<T> child : sourceNode.getChildren()) {
            if (isExist(child, targetNode)) {
                return true;
            }
        }
        return false;
    }

}
