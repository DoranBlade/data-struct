package string;

/**
 * 顺序结构的串
 */
public class ArrayString implements String {

    private static final int default_length = 0;
    private static final int default_size = 10;
    private static final int default_not_found = -1;

    private int length;
    private Character[] container;

    public ArrayString() {
        this.length = default_length;
        this.container = new Character[default_size];
    }

    public ArrayString(int length, Character[] container) {
        this.length = length;
        this.container = container;
    }

    @Override
    public String copy() {
        int length = container.length;
        Character[] copyContainer = new Character[length];
        for (int i = 0; i < length; i++) {
            copyContainer[i] = container[i];
        }
        return new ArrayString(length, copyContainer);
    }

    @Override
    public int length() {
        return length;
    }

    @Override
    public void clear() {
        if (isEmpty()) {
            return;
        }
        for (int i = 0; i < length; i++) {
            container[i] = null;
        }
        length = default_length;
    }

    @Override
    public boolean isEmpty() {
        return length == default_length;
    }

    @Override
    public boolean compare(String other) {
        return false;
    }

    @Override
    public String concat(String other) {
        if (other.isEmpty()) {
            return copy();
        }
        int totalLength = other.length() + length;
        Character[] newContainer = new Character[totalLength];
        int tempIndex = 0;
        for (; tempIndex < length; tempIndex++) {
            newContainer[tempIndex] = container[tempIndex];
        }
        for (int i = 0; i < other.length(); i++) {
            newContainer[tempIndex] = other.get(i);
            tempIndex++;
        }
        return new ArrayString(tempIndex, newContainer);
    }

    @Override
    public String subString(int index, int length) {
        if (length > this.length - 1) {
            length = this.length - index - 1;
        }
        String result = new ArrayString();
        for (int i = 0; i < length; i++) {
            result.insert(container[index + i]);
        }
        return result;
    }

    @Override
    public int index(String other) {
        // other串为空时，不匹配
        if (other.isEmpty()) {
            return default_not_found;
        }
        // other串长度大于当前串时，不匹配
        if (this.length < other.length()) {
            return default_not_found;
        }
        int otherLength = other.length();
        for (int i = 0; i <= length - otherLength; i++) {
            for (int j = 0; j < otherLength; j++) {
                // 字符序列段有一格字符不匹配时，不匹配
                if (container[i + j] != other.get(j)) {
                    break;
                }
                if (j == otherLength - 1) {
                    return i;
                }
            }

        }
        return default_not_found;
    }

    @Override
    public void replace(String match, String value) {
        if (match.isEmpty()) {
            return;
        }
        // 匹配和插入的索引位置
        int index = index(match);
        if (index != default_not_found) {
            // 删除匹配的元素
            delete(index, match.length());
            // 插入匹配的元素
            insert(index, value);
        }
    }

    @Override
    public void insert(int index, String value) {
        if (value.isEmpty()) {
            return;
        }
        grow(this.length + value.length());

        // index以及之后的元素向后移动value.length()
        for (int endIndex = length - 1; endIndex >= index; endIndex--) {
            container[endIndex + value.length()] = container[endIndex];
        }

        // value的元素填充进数组
        for (int i = 0; i < value.length(); i++) {
            container[index + i] = value.get(i);
        }
        if (index > length) {
            length = index;
        }
        length += value.length();
    }

    @Override
    public void delete(int index, int length) {
        // 确认向左移动的起点
        int startIndex = index + length;
        int removeCount = startIndex > this.length - 1 ? this.length - index - 1 : length;

        if (index + length > container.length - 1) {
            startIndex = container.length;
        }
        // 删除元素之后的元素统一向前移动一格
        for (; startIndex < this.length; startIndex++) {
            container[startIndex - length] = container[startIndex];
        }

        // 删除尾部遗留元素
        for (int i = 1; i <= removeCount; i++) {
            container[this.length - 1] = null;
            this.length--;
        }
    }

    @Override
    public Character get(int index) {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        return container[index];
    }

    @Override
    public void insert(Character value) {
        checkLength(length);
        container[length] = value;
        length++;
    }

    /**
     * 检查是否需要增长长度
     *
     * @param index
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
     * 自增长
     *
     * @param length
     */
    private void grow(int length) {
        if (length < this.length) {
            return;
        }
        int newLength = container.length * 2;
        while (newLength < length) {
            newLength *= 2;
        }
        Character[] newContainer = new Character[newLength];
        for (int i = 0; i < this.length; i++) {
            newContainer[i] = container[i];
        }
        container = newContainer;
    }
}
