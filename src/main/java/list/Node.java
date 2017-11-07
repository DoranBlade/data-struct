package list;

import model.Person;

public class Node {

    private Person value;
    private Node next;

    public Node() {
    }

    public Node(Person value, Node next) {
        this.value = value;
        this.next = next;
    }

    public Person getValue() {
        return value;
    }

    public void setValue(Person value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
