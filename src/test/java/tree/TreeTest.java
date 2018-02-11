package tree;

import faker.PersonFaker;
import model.Person;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;

/**
 * created by eric on 18-2-11
 */
public class TreeTest {

    @Test
    public void clear() {
        Tree<Person> tree = getInstance();
        assertThat(tree.isEmpty(), CoreMatchers.is(false));
        assertThat(tree.root().getChildren().size(), CoreMatchers.is(2));

        tree.clear();
        assertThat(tree.isEmpty(), CoreMatchers.is(true));
        assertThat(tree.root().getChildren().size(), CoreMatchers.is(0));
    }

    @Test
    public void isEmpty() {
        Tree<Person> tree = getInstance();
        assertThat(tree.isEmpty(), CoreMatchers.is(false));

        tree.clear();
        assertThat(tree.isEmpty(), CoreMatchers.is(true));
    }

    @Test
    public void root() {
        Tree<Person> tree = getInstance();
        Node<Person> rootNode = tree.root();
        assertThat(rootNode.getValue().getName(), CoreMatchers.is("root"));
    }

    @Test
    public void value() {
        Tree<Person> tree = getInstance();
        Node<Person> rootNode = tree.root();
        Person root = tree.value(rootNode);
        assertThat(root.getName(), CoreMatchers.is("root"));
    }

    @Test
    public void assign() {
        Person newValue = PersonFaker.getInstance();
        Tree<Person> tree = getInstance();
        tree.assign(tree.leftChild(tree.root()), newValue);

        assertThat(tree.leftChild(tree.root()).getValue(), CoreMatchers.sameInstance(newValue));
    }

    @Test
    public void parent() {
        Tree<Person> tree = getInstance();
        assertThat(tree.leftChild(tree.root()).getParent(), CoreMatchers.sameInstance(tree.root()));
        assertThat(tree.root().getParent(), CoreMatchers.nullValue());
    }

    @Test
    public void leftChild() {
        Tree<Person> tree = getInstance();
        assertThat(tree.leftChild(tree.root()), CoreMatchers.notNullValue());
    }

    @Test
    public void rightSibling() {
        Tree<Person> tree = getInstance();
        Node<Person> leftNode = tree.leftChild(tree.root());
        assertThat(tree.rightSibling(leftNode), CoreMatchers.notNullValue());
        Node<Person> rightNode = tree.rightSibling(leftNode);
        assertThat(tree.rightSibling(rightNode), CoreMatchers.nullValue());
    }

    @Test
    public void insertChild() {
        Tree<Person> tree =getInstance();
        tree.insertChild(tree.root(), getNode());
        assertThat(tree.root().getChildren().size(), CoreMatchers.is(3));
        Node<Person> rightNode = tree.rightSibling(tree.leftChild(tree.root()));
        assertThat(tree.rightSibling(rightNode), CoreMatchers.notNullValue());
    }

    @Test
    public void deleteChild() {
        Tree<Person> tree = getInstance();
        tree.deleteChild(tree.root(), 0);
        assertThat(tree.root().getChildren().size(), CoreMatchers.is(1));
        assertThat(tree.leftChild(tree.root()), CoreMatchers.notNullValue());
    }

    @Test
    public void isExist() {
        Tree<Person> tree = getInstance();
        Node<Person> leftNode = tree.leftChild(tree.root());
        Node<Person> rightNode = tree.rightSibling(tree.leftChild(tree.root()));
        Node<Person> otherNode = getNode();
        assertThat(tree.isExist(leftNode), CoreMatchers.is(true));
        assertThat(tree.isExist(rightNode), CoreMatchers.is(true));
        assertThat(tree.isExist(otherNode), CoreMatchers.is(false));
    }

    private Tree<Person> getInstance() {
        Tree<Person> tree = new LinkTree<>(new Person("root", 0));
        tree.insertChild(tree.root(), getNode());
        tree.insertChild(tree.root(), getNode());
        return tree;
    }

    private List<Node<Person>> getChildNode() {
        return Arrays.asList(getNode(), getNode(), getNode());
    }

    private Node<Person> getNode() {
        return new Node<>(PersonFaker.getInstance());
    }
}