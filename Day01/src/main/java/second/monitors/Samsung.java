package second.monitors;

import second.monitors.interfaces.DigitalPort;
import second.monitors.interfaces.HDMI;

public class Samsung implements HDMI, DigitalPort, Cloneable
{
    @Override
    public void connectToHDMI() {
        System.out.println("Connected to HDMI by Samsung");
    }

    @Override
    public void connectToDp() {
        System.out.println("Connected to DP by Samsung");
    }
}
