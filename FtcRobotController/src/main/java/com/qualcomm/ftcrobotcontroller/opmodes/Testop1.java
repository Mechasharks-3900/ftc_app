package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by stjzito1 on 10/13/2015.
 */
public class Testop1 extends OpMode {
    DcMotor motorone;

    public Testop1() {

    }

    public void init() {

    }

    public void loop() {
        float throttle = 1;
        motorone.setPower(throttle);

    }

    public void stop() {

    }
}
