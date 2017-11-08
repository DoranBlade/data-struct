package stack;

import model.Person;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by eric on 17-11-8
 */
public class LinkStackTest {
    @Test
    public void push() throws Exception {
        Stack stack = new LinkStack();
        for (int i = 0; i < 11; i++) {
            stack.push(Person.instance());
        }
        Assert.assertEquals(11, stack.length());
    }

    @Test
    public void get() throws Exception {
        Stack stack = new LinkStack();
        stack.push(Person.instance());
        stack.push(Person.instance());
        stack.push(new Person("tom", 12));
        Person person = stack.get();
        Assert.assertEquals("tom", person.getName());
        Assert.assertEquals(3, stack.length());
    }

    @Test
    public void pop() throws Exception {
        Stack stack = new LinkStack();
        stack.push(Person.instance());
        stack.push(Person.instance());
        stack.push(new Person("tom", 12));
        Person person = stack.pop();
        Assert.assertEquals("tom", person.getName());
        Assert.assertEquals(2, stack.length());
    }

    @Test
    public void clear() throws Exception {
        Stack stack = new LinkStack();
        stack.push(Person.instance());
        stack.push(Person.instance());
        stack.push(new Person("tom", 12));
        stack.clear();
        Assert.assertEquals(0, stack.length());
    }
}
