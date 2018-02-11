package vector;

import java.util.Comparator;

/**
 * Vector抽象接口
 * Created by eric on 17-10-31
 */
public interface Vector<T> {

    // 获取元素数量
    int size();

    // 容器大小
    int capacity();

    // 获取指定位置的元素
    T get(int index);

    // 替换指定位置上的元素
    void put(int index, T t);

    // 在指定位置上插入元素，其后元素向后移动
    void insert(int index, T t);

    // 删除指定位置的元素
    void remove(int index);

    // 删除区间元素
    void remove(int start, int end);

    // 排序元素
    void sort(Comparator<T> comparator);

    // 查找指定元素的位置
    int find(T t);

    // 删除重复元素
    void deduplicate();

}
