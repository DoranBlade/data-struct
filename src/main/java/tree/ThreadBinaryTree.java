package tree;

/**
 * created by eric on 18-2-13
 */
public class ThreadBinaryTree<T> {

    // 根节点
    private ThreadBinaryTreeNode<T> root;

    // 遍历时的前置节点
    private ThreadBinaryTreeNode<T> pre;


    public ThreadBinaryTree() {
    }

    public ThreadBinaryTree(ThreadBinaryTreeNode<T> root) {
        this.root = root;
    }

    /**
     * 前序遍历
     * @param node 当前节点
     * @return 查询结果
     */
    private void preOrder(ThreadBinaryTreeNode<T> node) {
        if (node != null) {
            // 左子节点为空
            if (node.getLeft() == null) {
                node.setlTag(ThreadBinaryTreeNodeTypeEnum.Thread);
                node.setLeft(pre);
            }
            // 右子节点为空
            if (node.getRight() == null) {
                pre.setrTag(ThreadBinaryTreeNodeTypeEnum.Thread);
                pre.setRight(node);
            }
            pre = node;
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }
}
