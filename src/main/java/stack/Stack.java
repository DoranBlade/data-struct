package stack;

import exception.OutBoundException;
import model.Person;

/**
 * Created by eric on 17-11-8
 */
public interface Stack {

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
     * @return 栈顶的元素
     */
    Person get() throws OutBoundException;

    /**
     * 元素入栈
     * @param person 需要入栈的元素
     */
    void push(Person person);

    /**
     * 栈顶元素出栈
     * @return 栈顶元素
     */
    Person pop() throws OutBoundException;

    /**
     * 元素的个数
     * @return
     */
    int length();
}
