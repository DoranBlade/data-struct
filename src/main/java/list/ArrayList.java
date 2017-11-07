package list;

import exception.OutBoundException;
import model.Person;

/**
 * 顺序结构线性表
 * Created by eric on 17-11-7
 */
public class ArrayList implements List {

    private static final int default_length = 0;
    private static final int default_size = 10;

    // 记录元素的数量
    private int length;

    // 保存元素的容器
    private Person[] container;

    public ArrayList() {
        this(default_size);
    }

    public ArrayList(int size) {
        this.length = default_length;
        this.container = new Person[size];
    }

    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    @Override
    public void clear() {
        while (length > 0) {
            length--;
            container[length] = null;
        }
    }

    @Override
    public Person get(int index) throws OutBoundException {
        if (index < 0 || index >=length) {
            throw new OutBoundException();
        }
        return container[index];
    }

    @Override
    public int find(Person person) {
        if (person == null) {
            return -1;
        }
        for (int i = 0; i < length; i++) {
            if (person.equals(container[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void insert(int index, Person person) {
        checkLength(index);
        // index索引之后的元素向后移动
        for (int endIndex = length; endIndex > index; endIndex--) {
            container[endIndex] = container[endIndex - 1];
        }
        container[index] = person;
        if (index >= length) {
            length = index + 1;
        } else {
            length++;
        }
    }

    @Override
    public void put(int index, Person person) throws OutBoundException{
        if (index >= length) {
            throw new OutBoundException();
        }
        container[index] = person;
    }

    @Override
    public Person delete(int index) throws OutBoundException {
        if (index < 0 || index >= length) {
            throw new OutBoundException();
        }
        Person removeItem = container[index];
        // index索引之后的元素向前移动
        while (index < length -1) {
            container[index] = container[index + 1];
            index++;
        }
        container[index] = null;
        return removeItem;
    }

    @Override
    public int length() {
        return length;
    }

    /**
     * 检查是否需要增长长度
     * 第一种情况是插入索引大于容器总长度
     * 第二种情况是插入索引小于容器总长度，但是容器已经没有空间了
     * @param index 需要插入的索引位置
     */
    private void checkLength(int index) {
        if (index >= container.length) {
            grow(index);
        }
        if (length >= container.length) {
            grow(length);
        }
    }

    /**
     * 增长容器长度
     * @param index 需要增长的最小索引
     */
    private void grow(int index) {
        int newCapacity = container.length * 2;
        while (index >= newCapacity) {
            newCapacity *= 2;
        }
        Person[] newContainer = new Person[newCapacity];
        for (int i = 0; i < container.length; i++) {
            newContainer[i] = container[i];
        }
        container = newContainer;
    }

}
