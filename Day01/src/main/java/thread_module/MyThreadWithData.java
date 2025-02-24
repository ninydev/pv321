package thread_module;

public class MyThreadWithData extends Thread{

    public final MyThreadData data;

    public MyThreadWithData(MyThreadData data) {
        this.data = data;
    }

    @Override
    public void run() {
        synchronized (this.data){
            work();
        }
    }


    public void work() {
        data.count = 0;
        for (int i = 0; i < 5; i++) {
            data.count++;
            this.data.name = currentThread().getName();

            try {
                Thread.sleep(100);
            }
            catch (InterruptedException e) {
                System.out.println(currentThread().getName() + " was interrupted during sleep");
                Thread.currentThread().interrupt(); // Preserve the interrupt status
                return;
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }


    }
}
