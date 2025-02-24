package thread_module;

public class MyThread extends Thread{

    @Override
    public void run() {
        System.out.println("\n\n ----- ");
        System.out.println("Thread Name: " + this.getName());
        System.out.println("Thread ID: " + this.getId());
        System.out.println("Thread State: " + this.getState());
    }
}
