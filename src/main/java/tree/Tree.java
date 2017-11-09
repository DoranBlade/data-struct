package tree;

import model.Person;

/**
 * 树的抽象数据类型
 * Created by eric on 17-11-9
 */
public interface Tree {

    /**
     * 清空树
     */
    void clear();

    /**
     * 树是否为空
     * @return 检查结果
     */
    boolean isEmpty();

    /**
     * 返回树的深度
     * @return
     */
    int depth();

    /**
     * 返回树的根节点
     * @return 树的根节点
     */
    Person root();


}
