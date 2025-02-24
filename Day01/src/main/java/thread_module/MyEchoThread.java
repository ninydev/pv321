package thread_module;

public class MyEchoThread extends Thread {
    private String name;
    private int repeatCount;


    public MyEchoThread(String name, int repeatCount) {
        this.name = name;
        this.repeatCount = repeatCount;
    }

    @Override
    public void run() {
        for (int i = 0; i < repeatCount; i++) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println(name + " was interrupted");
                return;
            }
            System.out.print(name + " ");
            try {
                Thread.sleep(100);
            }
            catch (InterruptedException e) {
                System.out.println(name + " was interrupted during sleep");
                Thread.currentThread().interrupt(); // Preserve the interrupt status
                return;
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
