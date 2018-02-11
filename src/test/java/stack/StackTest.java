package stack;

import model.Person;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * created by eric on 18-2-11
 */
public class StackTest {

    @Test
    public void push() throws Exception {
        pushTest(new ArrayStack<>());
        pushTest(new LinkStack<>());
    }
    private void pushTest(Stack<Person> stack) {
        for (int i = 0; i < 20; i++) {
            stack.push(Person.instance());
        }
        Assert.assertEquals(20, stack.length());
    }

    @Test
    public void get() throws Exception {
        getTest(new ArrayStack<>());
        getTest(new LinkStack<>());
    }
    private void getTest(Stack<Person> stack) {
        stack.push(Person.instance());
        stack.push(Person.instance());
        stack.push(new Person("tom", 12));
        Person person = stack.get();
        Assert.assertEquals("tom", person.getName());
        Assert.assertEquals(3, stack.length());
    }

    @Test
    public void pop() throws Exception {
        popTest(new ArrayStack<>());
        popTest(new LinkStack<>());
    }
    private void popTest(Stack<Person> stack) {
        stack.push(Person.instance());
        stack.push(Person.instance());
        stack.push(new Person("tom", 12));
        Person person = stack.pop();
        Assert.assertEquals("tom", person.getName());
        Assert.assertEquals(2, stack.length());
    }

    @Test
    public void clear() throws Exception {
        clearTest(new ArrayStack<>());
        clearTest(new LinkStack<>());
    }
    private void clearTest(Stack<Person> stack) {
        stack.push(Person.instance());
        stack.push(Person.instance());
        stack.push(new Person("tom", 12));
        stack.clear();
        Assert.assertEquals(0, stack.length());
    }
}