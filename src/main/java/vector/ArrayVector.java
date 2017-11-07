package vector;

import model.Person;

/**
 * 连续结构的Vector
 * Created by eric on 17-10-31
 */
public class ArrayVector implements Vector {

    public static final int defaultSize = 0;
    public static final int defaultCapacity = 10;

    // 记录已使用的元素数量
    private int size;

    // 容器的最大容量
    private int capacity;

    // 容器
    private Person[] container;

    public ArrayVector() {
        this.size = defaultSize;
        this.capacity = defaultCapacity;
        this.container = new Person[defaultCapacity];
    }


    @Override
    public int size() {
        return this.size;
    }

    @Override
    public int capacity() {
        return capacity;
    }

    @Override
    public Person get(int index) {
        if (index >= capacity) {
            throw new IndexOutOfBoundsException("数组越界");
        }
        return container[index];
    }

    @Override
    public void put(int index, Person person) {
        checkCapacity(index);
        container[index] = person;
        if (index >= size) {
            size = index + 1;
        }
    }

    @Override
    public void insert(int index, Person person) {
        checkCapacity(index);
        // index之后元素向后移动一个位置
        for (int end = size; end > index; end--) {
            container[end] = container[end - 1];
        }
        container[index] = person;
        if (index >= size) {
            size = index + 1;
        } else {
            size++;
        }
    }

    @Override
    public void remove(int index) {
        remove(index, index + 1);
    }

    @Override
    public void remove(int start, int end) {
        // end位置之后的元素向前移动
        int targetStart = start;
        for (int sourceStart = end; sourceStart < size; sourceStart++) {
            container[targetStart] = container[sourceStart];
            targetStart++;
        }
        // 移动完成后，targetStart位置之后的元素需要清空
        while (size > targetStart) {
            container[size] = null;
            size--;
        }
        // size增加一位
        size++;
    }

    @Override
    public void sort() {
        clearEmpty();
        for (int i = 0; i < size; i++) {
            int minIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (container[j].compareTo(container[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            Person temp = container[i];
            container[i] = container[minIndex];
            container[minIndex] = temp;
        }
    }

    @Override
    public int find(Person person) {
        for (int i = 0; i < size; i++) {
            if (container[i] == person) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void deduplicate() {
        // 重复元素标记为空
        for (int i = 0; i < size - 1; i++) {
            if (container[i] == null) {
                continue;
            }
            for (int j = i + 1; j < size; j++) {
                if (container[j] == null) {
                    continue;
                }
                if (container[j].equals(container[i])) {
                    container[j] = null;
                }
            }
        }
        // 清除空元素
        clearEmpty();
    }

    /**
     * 检查是否需要增长长度
     * 第一种情况是插入索引大于容器总长度
     * 第二种情况是插入索引小于容器总长度，但是容器已经没有空间了
     * @param index 需要插入的索引位置
     */
    private void checkCapacity(int index) {
        if (index >= capacity || size >= capacity) {
            grow(index);
        }
        if (size >= capacity) {
            grow(size);
        }
    }

    /**
     * 增长容器长度
     * @param index 需要增长的最小索引
     */
    private void grow(int index) {
        int newCapacity = capacity * 2;
        while (index >= newCapacity) {
            newCapacity *= 2;
        }
        Person[] newContainer = new Person[newCapacity];
        for (int i = 0; i < capacity; i++) {
            newContainer[i] = container[i];
        }
        capacity = newCapacity;
        container = newContainer;
    }

    /**
     * 去除空元素
     */
    private void clearEmpty() {
        // 非空元素依次向前移动
        int index = 0;
        for (int i = 0; i < size; i++) {
            if (container[i] != null && i != index) {
                container[index] = container[i];
            }
            if (container[i] != null) {
                index++;
            }
        }

        // 清空非空元素之后的空间
        while (size > index) {
            size--;
            container[size] = null;
        }
        size = index;
    }

}
