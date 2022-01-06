package learn.threadlearning;

import java.util.concurrent.*;

/**
 * @author Baven
 * @date 2021/12/9 12:27
 */
public class ForTest {
    public static void main(String[] args) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                2,
                7,
                5,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(),
                new MyThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );
    }

    static class MyThreadFactory implements ThreadFactory {
        @Override
        public Thread newThread(Runnable r) {
            return null;
        }
    }
}
