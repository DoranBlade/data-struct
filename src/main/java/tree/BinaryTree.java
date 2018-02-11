package tree;

/**
 * 二叉树
 * created by eric on 18-2-11
 */
public class BinaryTree<T> {

    private BinaryTreeNode<T> root;

    public BinaryTree() {
    }

    public BinaryTree(BinaryTreeNode<T> root) {
        this.root = root;
    }

    /**
     * 前序遍历查询
     * @param t 查询实例
     * @return 查询结果
     */
    public BinaryTreeNode<T> preOrderFind(T t) {
        if (t == null) {
            return null;
        }
        return preOrderFind(this.root, t);
    }
    private BinaryTreeNode<T> preOrderFind(BinaryTreeNode<T> node, T t) {
        if (node == null) {
            return null;
        }
        if (node.getValue() == t) {
            return node;
        }
        BinaryTreeNode<T> leftResult = preOrderFind(node.getLeft(), t);
        if (leftResult != null) {
            return leftResult;
        }
        BinaryTreeNode<T> rightResult = preOrderFind(node.getRight(), t);
        if (rightResult != null) {
            return rightResult;
        }
        return null;
    }

    /**
     * 中序遍历查询
     * @param t 查询对象
     * @return 查询结果
     */
    public BinaryTreeNode<T> inOrderFind(T t) {
        if (t == null) {
            return null;
        }
        return inOrderFind(this.root, t);
    }
    private BinaryTreeNode<T> inOrderFind(BinaryTreeNode<T> node, T t) {
        if (node == null) {
            return null;
        }
        BinaryTreeNode<T> leftNode = inOrderFind(node.getLeft(), t);
        if (leftNode != null) {
            return leftNode;
        }
        if (node.getValue() == t) {
            return node;
        }
        BinaryTreeNode<T> rightNode = inOrderFind(node.getRight(), t);
        if (rightNode != null) {
            return rightNode;
        }
        return null;
    }

    /**
     *
     * @param t
     * @return
     */
    public BinaryTreeNode<T> postOrderFind(T t) {
        if (t == null) {
            return null;
        }
        return postOrderFind(this.root, t);
    }
    private BinaryTreeNode<T> postOrderFind(BinaryTreeNode<T> node, T t) {
        if (node == null) {
            return null;
        }
        BinaryTreeNode<T> leftNode = postOrderFind(node.getLeft(), t);
        if (leftNode != null) {
            return leftNode;
        }
        BinaryTreeNode<T> rightNode = postOrderFind(node.getRight(), t);
        if (rightNode != null) {
            return rightNode;
        }
        if (node.getValue() == t) {
            return node;
        }
        return null;
    }
}
