package learn.lambdalearning;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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
     * 主要目的在于计算
     * 流的操作类型主要分为两种 1、中间操作 filter、map等 2、终端操作 count、collect等
     *
     * @param args
     */
    public static void main(String[] args) {
        List<Student> lists = getList();

        List<Integer> ages = new ArrayList<>();
        for (Student list : lists) {
            ages.add(list.getAge());
        }
        System.out.println("未简写： " + ages);
        // 上下功能一样
        ages = lists.stream().map(Student::getAge).collect(Collectors.toList());
        System.out.println("已简写： " + ages);
        System.out.println("==============================");

        List<String> list = Arrays.asList("a", "b", "c", "d");
        List<String> collect = list.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println("未转换： " + collect);
        System.out.println("已转换： " + list);
        System.out.println("==============================");

        List<Integer> num = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> collect1 = num.stream().map(n -> n * 2).collect(Collectors.toList());
        System.out.println("未 * 2： " + collect1);
        System.out.println("已 * 2： " + num);
        System.out.println("==============================");

        List<String> stringList = Arrays.asList("Java 8", "Lambdas",  "In", "Action");
        // 按照字符串的长度 映射出新的
        Stream<Integer> stream = stringList.stream().map(String::length);
        System.out.println(stream);
    }

    public static List<Student> getList() {
        int size = 10;
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            students.add(new Student((int) (Math.random() * 10)));
        }
        return students;
    }

    public static void createMethod() throws IOException {
        // 1.通过集合生成，应用中最常用的一种
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
        Stream<Integer> stream1 = integerList.stream();

        // 2.通过数组生成
        int[] intArr = new int[]{1, 2, 3, 4, 5};
        IntStream stream2 = Arrays.stream(intArr);

        // 3.通过值生成
        Stream<Integer> stream3 = Stream.of(1, 2, 3, 4, 5);

        // 4.通过文件生成
        Stream<String> lines = Files.lines(Paths.get("data.txt"), Charset.defaultCharset());

        // 5.通过函数生成 提供了iterate和generate两个静态方法从函数中生成流 iterator
        Stream<Integer> stream51 = Stream.iterate(0, n -> n + 2).limit(5);
        // generator
        Stream<Double> stream52 = Stream.generate(Math::random).limit(5);
    }
}
