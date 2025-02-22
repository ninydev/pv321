package exceptions;

public class work3 {

    public void Ex() throws MyException {
        throw new MyException("My Exception");

    }

    public static void main(String[] args) {

        int a = 10;
        int b = 0;
        int c = a / b;

        try {

            throw new MyException("My Exception");
        } catch (MyException e) {
            System.out.println(e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic Exception");
        } catch (Exception e) {
            System.out.println("Any Exception");
        }

        finally {
            System.out.println("Finally block");
        }

        System.out.println("I Still a life");
    }
}
