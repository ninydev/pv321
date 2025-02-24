package thread_module;

public class ClassWork_04 {


    public static void main(String[] args){
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
