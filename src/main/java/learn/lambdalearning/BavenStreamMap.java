package learn.lambdalearning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Baven
 * @date 2021/12/1 14:47
 */
public class BavenStreamMap {
    /**
     * 无存储。stream不是一种数据结构，它只是某种数据源的一个视图，数据源可以是一个数组，Java容器或I/O channel等。
     * 为函数式编程而生。对stream的任何修改都不会修改背后的数据源，比如对stream执行过滤操作并不会删除被过滤的元素，而是会产生一个不包含被过滤元素的新stream。
     * 惰式执行。stream上的操作并不会立即执行，只有等到用户真正需要结果的时候才会执行。
     * 可消费性。stream只能被“消费”一次，一旦遍历过就会失效，就像容器的迭代器那样，想要再次遍历必须重新生成。
     *
     * @param args
     */
    public static void main(String[] args) {
        List<Student> lists = getList();

        List<Integer> ages = new ArrayList<>();
        for (Student list : lists) {
            ages.add(list.getAge());
        }
        System.out.println(ages);
        // 上下功能一样
        ages = lists.stream().map(Student::getAge).collect(Collectors.toList());
        System.out.println(ages);

        List<String> list = Arrays.asList("a", "b", "c", "d");
        List<String> collect = list.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(collect);
        System.out.println(list);

        List<Integer> num = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> collect1 = num.stream().map(n -> n * 2).collect(Collectors.toList());
        System.out.println(collect1);
        System.out.println(num);
    }

    public static List<Student> getList() {
        int size = 10;
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            students.add(new Student((int) (Math.random() * 10)));
        }
        return students;
    }
}
