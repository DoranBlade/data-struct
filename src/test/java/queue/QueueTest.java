package queue;

import model.Person;
import org.junit.Assert;
import org.junit.Test;

/**
 * created by eric on 18-2-11
 */
public class QueueTest {

    @Test
    public void enqueue() throws Exception {
        enqueueTest(new ArrayQueue<>());
        enqueueTest(new LinkQueue<>());
    }
    private void enqueueTest(Queue<Person> queue) {
        for (int i = 0; i < 3; i++) {
            queue.enQueue(Person.instance());
        }
        Assert.assertEquals(3, queue.length());
    }

    @Test
    public void clear() throws Exception {
        clearTest(new ArrayQueue<>());
        clearTest(new LinkQueue<>());

    }
    private void clearTest(Queue<Person> queue) {
        for (int i = 0; i < 3; i++) {
            queue.enQueue(Person.instance());
        }
        queue.clear();
        Assert.assertEquals(0, queue.length());
    }

    @Test
    public void isEmpty() throws Exception {
        isEmptyTest(new ArrayQueue<>());
        isEmptyTest(new LinkQueue<>());
    }
    private void isEmptyTest(Queue<Person> queue) {
        for (int i = 0; i < 3; i++) {
            queue.enQueue(Person.instance());
        }
        Assert.assertTrue(queue.length() == 3);
        queue.clear();
        Assert.assertTrue(queue.length() == 0);
    }

    @Test
    public void get() throws Exception {
        getTest(new ArrayQueue<>());
        getTest(new LinkQueue<>());
    }
    private void getTest(Queue<Person> queue) {
        queue.enQueue(new Person("tom", 12));
        queue.enQueue(Person.instance());
        Assert.assertTrue("tom".equals(queue.get().getName()));
    }

    @Test
    public void dequeue() throws Exception {
       dequeueTest(new ArrayQueue<>());
       dequeueTest(new LinkQueue<>());
    }
    private void dequeueTest(Queue<Person> queue) {
        queue.enQueue(new Person("tom", 12));
        for (int i = 0; i < 3; i++) {
            queue.enQueue(Person.instance());
        }
        Person person = queue.deQueue();
        Assert.assertEquals("tom", person.getName());
        Assert.assertEquals(3, queue.length());
    }
}