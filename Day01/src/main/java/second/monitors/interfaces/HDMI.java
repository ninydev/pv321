package second.monitors.interfaces;

public interface HDMI {
    default void connectToHDMI() {
        System.out.println("Default HDMI connection");
    }
}
