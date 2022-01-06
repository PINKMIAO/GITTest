package learn.threadlearning;

import sun.misc.Contended;

import java.util.concurrent.CountDownLatch;

/**
 * 缓存行学习，一块缓存行的大小为64字节
 * 没加上缓存行结果：5553
 * 加上缓存行结果：1842
 * 有差别是因为，在底层一块cpu通过MESI机制通知向另外一块cpu：我们使用的同一块缓存行里有条数据我修改了，你要重新区内存里面获取一下
 * @Contended 注解添加，保证数据不会与其他数据在统一行，但需要在启动参数去掉限制 -XX:-RestrictContended
 *
 * @author Baven
 * @date 2021/12/16 15:47
 */
public class CacheLine {
    public static long COUNT = 10_0000_0000L;

    private static class T {
        private long p1, p2, p3, p4, p5, p6, p7;
        // @Contended
        public long x = 0L;
        private long p9, p10, p11, p12, p13, p14, p15;
    }

    public static T[] arr = new T[2];
    static {
        arr[0] = new T();
        arr[1] = new T();
    }

    public static void main(String[] args) throws Exception {
        CountDownLatch latch = new CountDownLatch(2);

        Thread t1 = new Thread(()->{
            for (long i = 0; i < COUNT; i++) {
                arr[0].x = i;
            }
            latch.countDown();
        });

        Thread t2 = new Thread(()->{
            for (long i = 0; i < COUNT; i++) {
                arr[1].x = i;
            }
            latch.countDown();
        });

        final long start = System.nanoTime();
        t1.start();
        t2.start();
        latch.await();

        System.out.println((System.nanoTime() - start)/100_0000);
    }
}
