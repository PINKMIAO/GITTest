import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Baven
 * @date 2021/11/11 13:52
 */
public class BavenForTest {
    public static void main(String[] args) {
        hello();
        lisa(new Student());
    }

    public static void hello() {
        System.out.println("hello, git");
    }

    public static void hello1(String name) {
        System.out.println("hello, " + name);
    }

    public static void hello2(String testName) {
        System.out.println("nana, " + testName);
    }

    public static void testsetsetset() {
        Integer i = 1;
        String username = "baven";
    }

    public static String testName() {
        return "String";
    }

    public static void hello3(String testName) {
        System.out.println("while");
        System.out.println(1 + 1);
    }

    public static void nihao(Integer number) {
        System.out.println("IIIIIIIIIIIIIIIIII");
    }

    public static void lisa(Student student) {
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<String, Integer> response = new HashMap<>(16);

        list.add(1);
        response.put("1111", 1111);

        list.forEach(System.out::println);

        /**
        list.stream().map(this::book).collect(Collectors.toList()); // 对象类型相同，只是名称不同的替换
        大创
        Optional.ofNullable(responseEntity.getBody()).orElseThrow(() -> new BusinessException("非法访问"));
        畅拓
        Optional<LibraryBook> existingBook = bookRepository.selectOne("book_name = ?", request.bookName);
        if (existingBook.isPresent()) {
            throw new ConflictException("book already exists, bookName=" + request.bookName);
        }

        Optional
        Optional 类是一个可以为null的容器对象。如果值存在则isPresent()方法会返回true，调用get()方法会返回该对象。
        Optional 是个容器：它可以保存类型T的值，或者仅仅保存null。Optional提供很多有用的方法，这样我们就不用显式进行空值检测。
        Optional 类的引入很好的解决空指针异常。
        public static String getGender(Student student) {
            if(null == student) {
                return "Unkown";
            }
            return student.getGender();
        }
        变为
        public static String getGender(Student student) {
            return Optional.ofNullable(student).map(u -> u.getGender()).orElse("Unkown");
        }
         **/


        // .of 是肯定有值    .ofNullable就不确定方法传进来的到底有没有值
        Optional<Student> aaa = Optional.ofNullable(student);
        System.out.println("optional: " + aaa);

        // 取出Student对象，再toString
        System.out.println(aaa.get().toString());
        // 直接从容器中取出的一致，前提是Student类中有toString
        System.out.println(aaa.orElseThrow(NullPointerException::new));
    }
}
