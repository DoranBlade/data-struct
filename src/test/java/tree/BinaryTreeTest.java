package tree;

import faker.PersonFaker;
import model.Person;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * created by eric on 18-2-11
 */
public class BinaryTreeTest {

    private Person flag = PersonFaker.getInstance();

    @Test
    public void preOrderFind() {
        BinaryTree<Person> binaryTree = instance();
        BinaryTreeNode<Person> result = binaryTree.preOrderFind(flag);
        assertThat(result, CoreMatchers.notNullValue());
        assertThat(result.getValue(), CoreMatchers.sameInstance(flag));
    }

    @Test
    public void inOrderFind() {
        BinaryTree<Person> binaryTree = instance();
        BinaryTreeNode<Person> result = binaryTree.inOrderFind(flag);
        assertThat(result, CoreMatchers.notNullValue());
        assertThat(result.getValue(), CoreMatchers.sameInstance(flag));
    }

    @Test
    public void postOrderFind() {
        BinaryTree<Person> binaryTree = instance();
        BinaryTreeNode<Person> result = binaryTree.postOrderFind(flag);
        assertThat(result, CoreMatchers.notNullValue());
        assertThat(result.getValue(), CoreMatchers.sameInstance(flag));
    }

    private BinaryTree<Person> instance() {
        return new BinaryTree<>(instanceNode());
    }
    private BinaryTreeNode<Person> instanceNode() {
        BinaryTreeNode<Person> root = new BinaryTreeNode<>(PersonFaker.getInstance());
        generateChild(root);
        generateChild(root.getLeft());
        generateChild(root.getRight());
        generateChild(root.getLeft().getLeft());
        generateChild(root.getLeft().getRight());
        generateChild(root.getRight().getLeft());
        generateChild(root.getRight().getRight());
        root.getLeft().getRight().setValue(flag);
        return root;
    }
    private void generateChild(BinaryTreeNode<Person> node) {
        node.setLeft(new BinaryTreeNode<>(PersonFaker.getInstance()));
        node.setRight(new BinaryTreeNode<>(PersonFaker.getInstance()));
    }

    @Test
    public void createHuffmanTree() {
        Person item1 = new Person("tom", 14);
        Person item2 = new Person("jack", 18);
        Person item3 = new Person("timi", 21);
        Person item4 = new Person("kakao", 25);
        BinaryTree<Person> huffmanTree = BinaryTree.createHuffmanTree(new Person[]{item1, item2, item3, item4});
        Assert.assertThat(huffmanTree, CoreMatchers.notNullValue());
    }
}