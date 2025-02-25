package thread_ad.myThreads;

import java.util.concurrent.Semaphore;

public class ByRunBySymaphore implements Runnable
{

    private final Semaphore semaphore;

    public ByRunBySymaphore() {
        this(new Semaphore(1));
    }

    public ByRunBySymaphore(Semaphore semaphore) {
        if (semaphore != null) {
            this.semaphore = semaphore;
        } else {
            this.semaphore = null;
        }
    }

    @Override
    public void run() {
        if (semaphore != null) {
            try {
                semaphore.acquire();
                System.out.println("Start " + Thread.currentThread().getName());
                hiLoad();
                semaphore.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void hiLoad() {
        long endTime = System.currentTimeMillis() + 7000; // 20 seconds
        while (System.currentTimeMillis() < endTime) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println(Thread.currentThread().getName() + " was interrupted");
                return;
            }
        }
        System.out.println("Finish " + Thread.currentThread().getName());
    }
}
