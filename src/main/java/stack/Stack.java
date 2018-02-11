package stack;

/**
 * Created by eric on 17-11-8
 */
public interface Stack<T> {

    /**
     * 清空栈
     */
    void clear();

    /**
     * 判断栈是否为空
     */
    boolean isEmpty();

    /**
     * 获取栈顶的元素
     *
     * @return 栈顶的元素
     */
    T get();

    /**
     * 元素入栈
     *
     * @param T 需要入栈的元素
     */
    void push(T t);

    /**
     * 栈顶元素出栈
     *
     * @return 栈顶元素
     */
    T pop();

    /**
     * 元素的个数
     *
     * @return
     */
    int length();
}
