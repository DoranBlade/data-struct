package list;

import model.Person;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by eric on 17-11-8
 */
public class LinkListTest {

    @Test
    public void insert() throws Exception {
        List list = new LinkList();
        list.insert(0, Person.instance());
        Assert.assertEquals(list.length(), 1);
        list.insert(10, Person.instance());
        Assert.assertEquals(11, list.length());
    }

    @Test
    public void put() throws Exception {
        List list = new LinkList();
        list.insert(0, Person.instance());
        list.insert(0, Person.instance());
        list.put(0, new Person("tom", 12));
        Assert.assertEquals(2, list.length());
        Assert.assertEquals("tom", list.get(0).getName());
    }

    @Test
    public void delete() throws Exception {
        List list = new LinkList();
        list.insert(0, new Person("tom", 12));
        list.insert(0, Person.instance());
        list.delete(0);
        Assert.assertEquals(1, list.length());
        Assert.assertEquals("tom", list.get(0).getName());
    }

    @Test
    public void clear() throws Exception {
        List list = new LinkList();
        list.insert(0, Person.instance());
        list.insert(0, Person.instance());
        list.clear();
        Assert.assertEquals(0, list.length());
    }

    @Test
    public void isEmpty() throws Exception {
        List list = new LinkList();
        Assert.assertEquals(list.isEmpty(), true);
    }
}
