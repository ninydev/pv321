package thread_ad.myThreads;

import java.util.concurrent.Semaphore;

public class ByRun implements Runnable
{

    @Override
    public void run() {
        System.out.println("Start " + Thread.currentThread().getName());
        hiLoad();
    }

    private void hiLoad() {
        long endTime = System.currentTimeMillis() + 500; // 20 seconds
        while (System.currentTimeMillis() < endTime) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println(Thread.currentThread().getName() + " was interrupted");
                return;
            }
        }
        System.out.println("Finish " + Thread.currentThread().getName());
    }
}
