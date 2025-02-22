package second;

public abstract class Helpers {

    public static void log(String[] args) {
    }

    public static void sendEvent(String[] args) {
    }

    public static void echoObjectTypes(Object object) {
        if(object instanceof BaseClass) {
            System.out.println("BaseClass");
            ((BaseClass) object).method1();
        } else {
            System.out.println("Unknown");
        }
        System.out.println(object.getClass().getName());
    }

}
