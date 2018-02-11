package list;

import model.Person;
import org.junit.Assert;
import org.junit.Test;

/**
 * created by eric on 18-2-10
 */
public class ListTest {

    @Test
    public void insert() throws Exception {
        insertTest(new ArrayList<>());
        insertTest(new LinkList<>());
    }
    private void insertTest(List<Person> list) {
        list.insert(0, Person.instance());
        Assert.assertEquals(list.length(), 1);
        list.insert(10, Person.instance());
        Assert.assertEquals(11, list.length());
    }

    @Test
    public void put() throws Exception {
         putTest(new ArrayList<>());
         putTest(new LinkList<>());
    }
    private void putTest(List<Person> list) {
        list.insert(0, Person.instance());
        list.insert(0, Person.instance());
        list.put(0, new Person("tom", 12));
        Assert.assertEquals(2, list.length());
        Assert.assertEquals("tom", list.get(0).getName());
    }

    @Test
    public void delete() throws Exception {
        deleteTest(new LinkList<>());
        deleteTest(new ArrayList<>());
    }
    private void deleteTest(List<Person> list) {
        list.insert(0, new Person("tom", 12));
        list.insert(0, Person.instance());
        list.delete(0);
        Assert.assertEquals(1, list.length());
        Assert.assertEquals("tom", list.get(0).getName());
    }

    @Test
    public void clear() throws Exception {
        clearTest(new LinkList<>());
        clearTest(new ArrayList<>());
    }
    private void clearTest(List<Person> list) {
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