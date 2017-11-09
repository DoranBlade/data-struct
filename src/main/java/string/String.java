package string;

import exception.OutBoundException;

public interface String {

    /**
     * 复制串
     * @return
     */
    String copy();

    /**
     * 串的长度
     * @return
     */
    int length();

    /**
     * 清空串
     */
    void clear();

    /**
     * 是否为空
     */
    boolean isEmpty();

    /**
     * 比较串是否相等
     * @return
     */
    boolean compare(String other);

    /**
     * 拼接两个串
     * @param other 需要拼接的另外一个串
     * @return 拼接结果
     */
    String concat(String other) throws OutBoundException;

    /**
     * 返回index开始，length长度的子串
     * @param index 开始索引
     * @param length 截取长度
     * @return 截取后的子串
     */
    String subString(int index, int length);

    /**
     * 返回是否包含other子串
     * @param other
     * @return
     */
    int index(String other) throws OutBoundException;

    /**
     * 使用value字符串替换match字符串
     * @param match 需要替换的字符
     * @param value 替换的字符
     */
    void replace(String match, String value) throws OutBoundException;

    /**
     * 在index位置之前插入value字符串
     * @param index 插入字符的位置
     * @param value value字符串值
     */
    void insert(int index, String value) throws OutBoundException;

    /**
     * 删除指定位置开始，指定长度的子串
     * @param index 开始位置
     * @param length 指定长度
     */
    void delete(int index, int length);

    /**
     * 获取指定位置的字符
     * @param index
     * @return
     */
    Character get(int index) throws OutBoundException;

    /**
     * 在串的尾部插入单个字符
     * @param value
     */
    void insert(Character value);
}
