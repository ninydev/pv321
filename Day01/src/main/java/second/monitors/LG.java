package second.monitors;

import second.monitors.interfaces.HDMI;

public class LG implements HDMI {

    @Override
    public void connectToHDMI() {
        HDMI.super.connectToHDMI();
        System.out.println("Connected to HDMI by LG");
    }
}
