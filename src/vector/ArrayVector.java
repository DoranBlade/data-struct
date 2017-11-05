package vector;

/**
 * 连续结构的Vector
 * Created by eric on 17-10-31
 */
public class ArrayVector implements Vector {

    private static final int defaultSize = 0;
    private static final int defaultCapacity = 10;

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
        return container.length;
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

    }

    @Override
    public void insert(int index, Person person) {

    }

    @Override
    public void remove(int index) {

    }

    @Override
    public void remove(int start, int end) {

    }

    @Override
    public void sort() {

    }

    @Override
    public int find(Person person) {
        return 0;
    }

    @Override
    public void deduplicate() {

    }

    /**
     * 检查是否需要增长长度
     * @param index
     */
    private void checkCapacity(int index) {
        if (index >= capacity || size >= capacity) {
            grow();
        }
    }

    /**
     * 自增长容器长度
     */
    private void grow() {
        int newCapacity = capacity * 2;
        Person[] newContainer = new Person[newCapacity];
        for (int i = 0; i < capacity; i++) {
            newContainer[i] = container[i];
        }
        capacity = newCapacity;
        container = newContainer;
    }
}
