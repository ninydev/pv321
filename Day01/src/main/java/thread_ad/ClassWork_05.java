package thread_ad;

import thread_ad.myThreads.ByRun;
import thread_ad.myThreads.ByRunBySymaphore;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class ClassWork_05 {

    public static void main(String [] args){

        int count = 1000;

        ByRun byRun = new ByRun();

        // ArrayList<Thread> threads = new ArrayList<>();
        ExecutorService executorService = Executors
                .newFixedThreadPool(10);

        for (int i = 0; i < count; i++) {
//        for (int i = 0; i < count; i++) {
//            threads.add(new Thread(byRun));
//        }
//        for (int i = 0; i < count; i++) {
//            threads.get(i).start();
//        }
            executorService.submit(byRun);
            System.out.println("Add");
        }



        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }

        System.out.println("\n\n --- App finish");

    }





    public static void main2(String [] args) {

        Semaphore semaphore = new Semaphore(11);

        ByRunBySymaphore byRun = new ByRunBySymaphore(semaphore);
        int count = 1000;

        ArrayList<Thread> threads = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            threads.add(new Thread(byRun));
        }

        for (int i = 0; i < count; i++) {
            threads.get(i).start();
        }

        System.out.println("\n\n --- App finish");

    }



    public static void main1(String [] args) {

        ByRun byRun = new ByRun();
        Thread t1 = new Thread(byRun);

        t1.start();

        try {
            t1.join(2000);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }

        if (t1.isAlive()) {

            System.out.println("Thread did not finish within 2 seconds.");
            t1.interrupt();
            while (t1.isAlive()) {
                System.out.print(".");
//                try
//                {
//                    Thread.sleep(1);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }

            }
            System.out.println();
        }




        System.out.println("\n\n --- App finish");
    }
}
