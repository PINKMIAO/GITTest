package lambdalearning;

/**
 * @author Baven
 * @date 2021/11/23 10:21
 */
public class Something {
    Something() {}

    Something(String something) {
        System.out.println(something);
    }

    static String startsWith(String s) {
        return String.valueOf(s.charAt(0));
    }

    String endWith(String s) {
        return String.valueOf(s.charAt(s.length()-1));
    }
}
/**
 * ::表达式[Class::method] -- lambda表达式的一种简写形式。
 * 当此表达式中右侧的方法，与要实现方法的格式(包括参数类型与返回值类型)匹配时，可用::表达式替代普通的lambda表达式[() -> {}]。 应用场景：已存在目标接口方法的具体实现，避免重复代码。
 * 用 '::' 来访问类Something中的方法，必须要用 functional interface 来接收，所以需先定义一个接口
 * 否则编译错误（The target type of this expression must be a functional interface）
 */

/**
 * 做 lambda 学习的接口
 * @param <F> 来源数据
 * @param <T> 返回数据
 */
@FunctionalInterface
interface IConvert<F, T> {
    T convert(F form);
}

/**
 * 自己随意创建的函数式接口
 * @param <F>
 * @param <T>
 */
@FunctionalInterface
interface IMyBaven<F, T> {
    T myBaven(F from);
}