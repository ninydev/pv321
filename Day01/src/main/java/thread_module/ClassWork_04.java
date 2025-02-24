package thread_module;

public class ClassWork_04 {

    public static void main(String[] args) {
        MyThreadData data = new MyThreadData();

        MyThreadWithData t1 = new MyThreadWithData(data);
        MyThreadWithData t2 = new MyThreadWithData(data);
        MyThreadWithData t3 = new MyThreadWithData(data);
        MyThreadWithData t4 = new MyThreadWithData(data);

        t4.start();
        t2.start();
        t3.start();
        t1.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
        }


        System.out.println(data.name);
        System.out.println(data.count);


    }

    public static void main2(String[] args) {

        MyEchoThread t1 = new MyEchoThread("1", 2);
        t1.setPriority(Thread.MAX_PRIORITY);
        MyEchoThread t2 = new MyEchoThread("2", 2);
        MyEchoThread t3 = new MyEchoThread("3", 2);
        MyEchoThread t4 = new MyEchoThread("4", 2);
        MyEchoThread t5 = new MyEchoThread("5", 20);
        //t5.setDaemon(true);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        System.out.println("Start wait All threads have finished");
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n\n All threads have finished execution.");

        t5.interrupt();



//        try {
//            Thread.sleep(1000);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }

//        t1.run();
//        t2.run();
//        t3.run();
//        t4.run();
//        t5.run();

    }

    public static void main1(String[] args){
        System.out.println("Main Thread");

        Thread currentThread = Thread.currentThread();
        System.out.println("Current Thread: " + currentThread.getName());
        System.out.println("Thread ID: " + currentThread.getId());
        System.out.println("Thread State: " + currentThread.getState());

        MyThread myThread = new MyThread();

        System.out.println("\n\nBefore start MyThread: " + myThread.getName());
        System.out.println("Thread ID: " + myThread.getId());
        System.out.println("Thread State: " + myThread.getState());

        myThread.run(); // метод буде виконуватися у томуж потоці
        myThread.start();

        System.out.println("\n\nAfter start MyThread: " + myThread.getName());
        System.out.println("Thread ID: " + myThread.getId());
        System.out.println("Thread State: " + myThread.getState());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("\n\nAfter sleep MyThread: " + myThread.getName());
        System.out.println("Thread ID: " + myThread.getId());
        System.out.println("Thread State: " + myThread.getState());



    }

}
