package lambdalearning;

/**
 * lambda 学习
 * @author Baven
 * @date 2021/11/25 13:47
 */
public class LambdaLearning {
    interface MathOperation {
        /**
         * 学习 lambda
         * @param a 数字a
         * @param b 数字b
         * @return 返回操作后的值
         */
        int operator(int a, int b);
    }

    public int math(int a, int b, MathOperation math) {
        return math.operator(a, b);
    }

    /**
     * (a, b) -> a + b 就是对接口 MathOperation 的实现缩写而已
     * 实际为 MathOperation math = (a, b) -> a + b; 省略的前部分而已；
     * 类似 new Student() 一样，省略了前面的 Student stu
     */
    public static void main(String[] args) {
        System.out.println(new LambdaLearning().math(1, 2, (a, b) -> a + b));
        // (a, b) -> a + b 系统建议更改为 Integer::sum

        new LambdaLearning().test01();
    }

    /**
     * 细看省略步骤
     */
    public void test01() {
        // 1.最开始的实现方式
        MathOperation math1 = new MathOperation() {
            @Override
            public int operator(int a, int b) {
                return a + b;
            }
        };
        System.out.println(math(1, 2, math1));

        // 2.省略版本，其中 (int a, int b) 的int 可不加
        MathOperation math2 = (int a, int b) -> a + b;
        System.out.println(math(2, 2, math2));

        // 3.更精简，也是我们常做的一种 : test(new Student()) {}
        System.out.println(math(3, 3, (int a, int b) -> a + b));

        // 4.使用 :: 进行表达
        System.out.println(math(4, 4, Integer::sum));
    }
}
