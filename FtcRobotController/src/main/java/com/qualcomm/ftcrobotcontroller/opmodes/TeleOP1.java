package com.qualcomm.ftcrobotcontroller.opmodes;

/**
 * Created by stjzito1 on 11/24/2015.
 */
public class TeleOP1 extends Super{
    public void init() {
        setup();
        tankMode=1;
    }
    public void loop() {
        driveTeleOP();
    }
}
