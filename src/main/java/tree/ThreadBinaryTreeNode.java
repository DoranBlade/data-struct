package tree;

/**
 * 线索二叉树节点
 * created by eric on 18-2-13
 */
public class ThreadBinaryTreeNode<T> {

    // 节点值
    private T value;

    // 左子节点
    private ThreadBinaryTreeNode<T> left;

    // 右节点
    private ThreadBinaryTreeNode<T> right;

    // 左子节点类型
    private ThreadBinaryTreeNodeTypeEnum lTag;

    // 右子节点类型
    private ThreadBinaryTreeNodeTypeEnum rTag;

    public ThreadBinaryTreeNode(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public ThreadBinaryTreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(ThreadBinaryTreeNode<T> left) {
        this.left = left;
    }

    public ThreadBinaryTreeNode<T> getRight() {
        return right;
    }

    public void setRight(ThreadBinaryTreeNode<T> right) {
        this.right = right;
    }

    public ThreadBinaryTreeNodeTypeEnum getlTag() {
        return lTag;
    }

    public void setlTag(ThreadBinaryTreeNodeTypeEnum lTag) {
        this.lTag = lTag;
    }

    public ThreadBinaryTreeNodeTypeEnum getrTag() {
        return rTag;
    }

    public void setrTag(ThreadBinaryTreeNodeTypeEnum rTag) {
        this.rTag = rTag;
    }
}
