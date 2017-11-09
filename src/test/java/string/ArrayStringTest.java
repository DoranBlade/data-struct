package string;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by eric on 17-11-9
 */
public class ArrayStringTest {

    @Test
    public void insert() throws Exception {
        String string = new ArrayString();
        string.insert('t');
        string.insert('o');
        string.insert('m');
        Assert.assertEquals(3, string.length());
    }

    @Test
    public void isEmpty() throws Exception {
        String string = new ArrayString();
        Assert.assertTrue(string.isEmpty());
        string.insert('t');
        Assert.assertTrue(!string.isEmpty());
    }

    @Test
    public void clear() throws Exception {
        String string = new ArrayString();
        string.insert('t');
        string.insert('o');
        string.insert('m');
        string.clear();
        Assert.assertTrue(string.isEmpty());
    }

    @Test
    public void get() throws Exception {
        String string = new ArrayString();
        string.insert('t');
        string.insert('o');
        string.insert('m');
        Assert.assertEquals((long)'t', (long)string.get(0));
    }

    @Test
    public void copy() throws Exception {
        String string = new ArrayString();
        string.insert('t');
        string.insert('o');
        string.insert('m');
        String copy = string.copy();
        Assert.assertEquals((long)string.get(0), (long)copy.get(0));
        Assert.assertEquals((long)string.get(1), (long)copy.get(1));
        Assert.assertEquals((long)string.get(2), (long)copy.get(2));
    }

    @Test
    public void concat() throws Exception {
        String string = new ArrayString();
        string.insert('t');
        string.insert('o');
        string.insert('m');
        String string1 = new ArrayString();
        string1.insert('t');
        string1.insert('o');
        string1.insert('m');
        String concat = string.concat(string1);
        Assert.assertEquals(6, concat.length());
    }

    @Test
    public void delete() throws Exception {
        String string = new ArrayString();
        string.insert('t');
        string.insert('o');
        string.insert('m');
        string.insert('t');
        string.insert('o');
        string.insert('m');
        string.delete(3,2);
        Assert.assertEquals(4, string.length());
        Assert.assertEquals((long)'m', (long)string.get(3));
    }

    @Test
    public void subString() throws Exception {
        String string = new ArrayString();
        string.insert('t');
        string.insert('o');
        string.insert('m');
        string.insert('t');
        string.insert('o');
        string.insert('m');
        String sub = string.subString(3, 10);
        Assert.assertEquals(2, sub.length());
        Assert.assertEquals((long)'t', (long)sub.get(0));
    }

    @Test
    public void insertString() throws Exception {
        String string = new ArrayString();
        string.insert('t');
        string.insert('o');
        string.insert('m');
        String source = new ArrayString();
        source.insert('j');
        source.insert('a');
        source.insert('c');
        source.insert('k');
        source.insert(5, string);
        Assert.assertEquals(8, source.length());
        Assert.assertEquals((long)'m', (long)source.get(7));
    }

    @Test
    public void index() throws Exception {
        String source = new ArrayString();
        source.insert('j');
        source.insert('a');
        source.insert('c');
        source.insert('k');
        String other = new ArrayString();
        other.insert('t');
        other.insert('o');
        other.insert('m');
        String other1 = new ArrayString();
        other1.insert('c');
        String other2 = new ArrayString();
        other2.insert('c');
        other2.insert('k');
        int index = source.index(other);
        Assert.assertEquals(-1, index);
        int index1 = source.index(other1);
        Assert.assertEquals(2, index1);
        int index2 = source.index(other2);
        Assert.assertEquals(2, index2);
    }

    @Test
    public void replace() throws Exception {
        String s1 = new ArrayString();
        s1.insert('o');
        s1.insert('k');
        String s2 = new ArrayString();
        s2.insert('a');
        s2.insert('c');
        String replace = new ArrayString();
        replace.insert('r');
        replace.insert('e');
        replace.insert('p');
        replace.insert('l');
        replace.insert('a');
        replace.insert('e');
        String source = new ArrayString();
        source.insert('j');
        source.insert('a');
        source.insert('c');
        source.insert('k');
        source.replace(s1, replace);
        Assert.assertEquals(4, source.length());
        source.replace(s2, replace);
        Assert.assertEquals(8, source.length());
    }
}
