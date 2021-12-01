package strategy;

/**
 * @author Baven
 */
public interface Comparable<T> {
    /**
     * 自己做一个比较接口
     *
     * @param o 泛型参数
     * @return 返回 -1 0 1
     */
    int compareTo(T o);
}
