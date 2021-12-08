package learn.threadlearning;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Baven
 * @date 2021/12/8 15:35
 */
public class Thread_interrupt_synchronized_and_lock {
    // interrupt 是否会干扰synchronized锁和lock锁？
    // 因为只是interrupt只是对标记位做标记，该怎么操作还是由线程处理
    // 所以根本不会因为用了interrupt而影响到锁。

    // 但是！就是想打断干扰到锁的争抢
    // 用lock.lockInterruptibly(); 作用是看有没有人设置标志位，有的话就抛出异常，在异常中处理线程
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Thread t1 = new Thread(() -> {
            lock.lock();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
            System.out.println("t1 end");
        });
        t1.start();

        Thread t2 = new Thread(() -> {
            try {
                lock.lockInterruptibly();
                lock.lock();
            } catch (InterruptedException e) {
                System.out.println("t2的争抢被打断了");
            } finally {
                lock.unlock();
            }
        });
        t2.start();
        t2.interrupt();
    }
}
