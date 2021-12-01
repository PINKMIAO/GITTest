package strategy;

/**
 * @author Baven
 */
@FunctionalInterface
public interface Comparator<T> {
    /**
     * 自己创建一个比较器接口
     *
     * @param o1 比较对象
     * @param o2 比较对象
     * @return -1 0 1
     */
    int compare(T o1, T o2);

    default void m() {
        System.out.println("m");
    }
}
