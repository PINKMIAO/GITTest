package learn.threadlearning;

/**
 * @author Baven
 * @date 2021/12/8 15:07
 */
public class Thread_interrupt_sleep_and_wait {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                // 捕获到异常后，Java会默认的复位标志位
                // 对sleep wait join 的线程进行 interrupted 会触发异常
                // 但主动权还是在我们自己线程这里
                System.out.println("Thread is interrupted");
                System.out.println("内：" + Thread.currentThread().isInterrupted());
            }
        });
        t1.start();
        t1.interrupt();
        System.out.println("外：" + t1.isInterrupted());

        final Object o = new Object();
        Thread t2 = new Thread(() -> {
            synchronized (o) {
                try {
                    o.wait();
                } catch (InterruptedException e) {
                    // 与上相同
                    System.out.println("Thread is interrupted");
                    System.out.println("内：" + Thread.currentThread().isInterrupted());
                }
            }
        });
        t2.start();
        t2.interrupt();
        System.out.println("外：" + t2.isInterrupted());


    }
}
