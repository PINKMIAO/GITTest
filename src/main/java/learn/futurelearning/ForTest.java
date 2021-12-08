package learn.futurelearning;

import java.util.concurrent.*;

/**
 * @author Baven
 * @date 2021/12/7 12:25
 */
public class ForTest {
    public static void main(String[] args) {
        ExecutorService cachePool = Executors.newCachedThreadPool();
        Future<String> future = cachePool.submit(() -> {
            Thread.sleep(3000);
            return "异步任务计算结果!";
        });
    }
}
