package list;

/**
 * Created by eric on 17-11-7
 */
public interface List<T> {

    /**
     * 判断线性表是否为空
     *
     * @return 是否为空
     */
    boolean isEmpty();

    /**
     * 清空线性表
     */
    void clear();

    /**
     * 获取指定位置的元素
     *
     * @param index 元素的索引
     * @return 元素
     */
    T get(int index);

    /**
     * 查找指定元素在线性表中的索引位置
     *
     * @param t 需要查找的元素
     * @return 索引位置，-1为没有找到
     */
    int find(T t);

    /**
     * 指定位置插入元素
     *
     * @param index 插入的索引位置
     * @param t     插入的元素
     */
    void insert(int index, T t);

    /**
     * 指定位置设置元素
     *
     * @param index 设置的索引位置
     * @param t     设置的元素
     */
    void put(int index, T t);

    /**
     * 删除index位置的元素，并返回该元素
     *
     * @param index 需要删除元素的索引
     * @return 被删除的元素
     */
    T delete(int index);

    /**
     * 线性表元素的数量
     *
     * @return 数量
     */
    int length();
}
