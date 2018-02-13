package tree;

import model.Person;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 二叉树
 * created by eric on 18-2-11
 */
public class BinaryTree<T extends Cloneable> {

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

    public static BinaryTree<Person> createHuffmanTree(Person[] sortArray) {

        List<BinaryTreeNode<Person>> binaryTreeNodes = convert(sortArray);

        // 组装的临时节点
        BinaryTreeNode<Person> currentNode = createHuffmanTreeNode(binaryTreeNodes.get(0), binaryTreeNodes.get(1));
        for (int i = 2; i < sortArray.length; i++) {
            currentNode = createHuffmanTreeNode(currentNode, binaryTreeNodes.get(i));
        }
        return new BinaryTree<>(currentNode);
    }

    /**
     * 创建哈夫曼树节点
     * @return 节点
     */
    private static BinaryTreeNode<Person> createHuffmanTreeNode(BinaryTreeNode<Person> nodeA, BinaryTreeNode<Person> nodeB) {
        Person temp = new Person("temp", nodeA.getValue().getAge() + nodeB.getValue().getAge());
        BinaryTreeNode<Person> newNode = new BinaryTreeNode<>();
        newNode.setValue(temp);
        if (nodeA.getValue().getProportion() >= nodeB.getValue().getProportion()) {
            newNode.setLeft(nodeB);
            newNode.setRight(nodeA);
        } else {
            newNode.setLeft(nodeA);
            newNode.setRight(nodeB);
        }
        return newNode;
    }

    /**
     * 先Person实例做排序操作
     * 然后转换成二叉树节点实例
     * @param sortArray person实例节点
     * @return 转换结果
     */
    private static List<BinaryTreeNode<Person>> convert(Person[] sortArray) {
        return Arrays.stream(sortArray)
                .sorted(Comparator.comparingInt(Person::getAge))
                .map(BinaryTreeNode::new).collect(Collectors.toList());
    }
}
