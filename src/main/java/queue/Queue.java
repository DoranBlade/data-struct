package queue;

/**
 * 队列抽象数据结构
 * Created by eric on 17-11-8
 */
public interface Queue<T> {

    /**
     * 清空队列
     */
    void clear();

    /**
     * 判断队列是否为空
     *
     * @return 队列是否为空
     */
    boolean isEmpty();

    /**
     * 队列长度
     *
     * @return 长度
     */
    int length();

    /**
     * 获取队列起始位置的元素
     *
     * @return 起始位置的元素
     */
    T get();

    /**
     * 队列起始位置的元素出队
     *
     * @return 出队的元素
     */
    T deQueue();

    /**
     * 队列尾部插入一个元素
     *
     * @param T 需要插入的元素
     */
    void enQueue(T t);

}
