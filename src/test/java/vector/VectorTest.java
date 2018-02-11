package vector;

import model.Person;
import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;

public class VectorTest {

    @Test
    public void crete() throws Exception {
        ArrayVector<Person> arrayVector = new ArrayVector<>();
        Assert.assertNotNull(arrayVector);
        Assert.assertEquals(ArrayVector.defaultCapacity, arrayVector.capacity());
        Assert.assertEquals(ArrayVector.defaultSize, arrayVector.size());
    }

    @Test
    public void putAndGet() throws Exception {
        Person person = Person.instance();
        ArrayVector<Person> arrayVector = new ArrayVector<>();
        arrayVector.put(10, person);
        Assert.assertEquals(person, arrayVector.get(10));
    }

    @Test
    public void size() throws Exception {
        Person person = Person.instance();
        ArrayVector<Person> arrayVector = new ArrayVector<>();
        arrayVector.put(10, person);
        Assert.assertEquals(11, arrayVector.size());
        arrayVector.put(20, person);
        Assert.assertEquals(21, arrayVector.size());
    }

    @Test
    public void capacity() throws Exception {
        Person person = Person.instance();
        ArrayVector<Person> arrayVector = new ArrayVector<>();
        arrayVector.put(10, person);
        Assert.assertTrue(arrayVector.capacity() > 10);
    }

    @Test
    public void insert() throws Exception {
        Person person = Person.instance();
        ArrayVector<Person> arrayVector = new ArrayVector<>();
        arrayVector.insert(3, person);
        Assert.assertEquals(person, arrayVector.get(3));
        arrayVector.insert(1, person);
        Assert.assertEquals(person, arrayVector.get(1));
        Assert.assertEquals(person, arrayVector.get(4));
    }

    @Test
    public void remove() throws Exception {
        ArrayVector<Person> arrayVector = new ArrayVector<>();
        for (int i = 0; i <50; i++) {
            if (i % 2 == 0) {
                arrayVector.put(i, Person.instance());
            }
        }
        arrayVector.remove(10, 15);
        Assert.assertEquals(arrayVector.size(), 45);
    }

    @Test
    public void sort() throws Exception {
        ArrayVector<Person> arrayVector = new ArrayVector<>();
        for (int i = 0; i <50; i++) {
            if (i % 2 == 0) {
                arrayVector.put(i, Person.instance());
            }
        }
        arrayVector.sort(Comparator.comparingInt(Person::getAge));
        for (int i = 0; i < arrayVector.size(); i++) {
            Assert.assertTrue(arrayVector.get(i).compareTo(arrayVector.get(i++)) <= 0);
        }
    }

    @Test
    public void deduplicate() throws Exception {
        Person person = Person.instance();
        ArrayVector<Person> arrayVector = new ArrayVector<>();
        for (int i = 0; i < 50; i++) {
            if (i %2 == 0) {
                arrayVector.put(i, person);
            }
        }
        arrayVector.deduplicate();
        Assert.assertTrue(arrayVector.size() == 1);
    }
}
