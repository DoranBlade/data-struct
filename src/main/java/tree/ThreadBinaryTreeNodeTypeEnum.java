package tree;

/**
 * 线索二叉树节点类型
 * created by eric on 18-2-13
 */
public enum ThreadBinaryTreeNodeTypeEnum {
    Link(0), Thread(1);

    private int value;

    ThreadBinaryTreeNodeTypeEnum(int value) {
        this.value = value;
    }
}
