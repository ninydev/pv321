package files;



import java.io.FileInputStream;
import java.io.FileOutputStream;

public class WorkWithFiles implements Runnable
{
    @Override
    public void run() {

        writeToFile();
        readFromFile();

    }

    private String fileName = "MyFile.txt";

    /**
     * Write to file
     */
    private void writeToFile() {
        System.out.println("Write to file");

        String msg = "Hello World!";

        try (FileOutputStream fos = new FileOutputStream(fileName))
        {
            byte[] buffer = msg.getBytes();

            fos.write(buffer, 0, buffer.length);

            System.out.println("The file has been written");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Read from file
     */
    private void readFromFile() {
        System.out.println("Read from file");
        try (FileInputStream fis = new FileInputStream(fileName))
        {
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer, 0, buffer.length);
            System.out.println("The file has been read: " + new String(buffer));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
