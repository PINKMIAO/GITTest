package learn.threadlearning;

/**
 * @author Baven
 * @date 2021/12/8 15:05
 */
public class Thread_interrupt {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            for (;;) {
                // Thread.currentThread() 这里代表的是 t 线程，在外的话代表的是主线程
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("The Thread is interrupted!");
                    System.out.println(Thread.currentThread().isInterrupted());
                    // 这是比较优雅的结束方式
                    break;
                }
            }
        });
        t.start();
        System.out.println(t.getState());
        t.interrupt();
        System.out.println(t.getState());

        System.out.println(Thread.currentThread().isInterrupted());
        // 静态
        System.out.println(Thread.interrupted());
    }
}
