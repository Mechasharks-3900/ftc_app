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
        float throttle = gamepad1.left_stick_y;
        motorone.setPower(throttle);
        telemetry.addData("2 Status", "running for " + runtime.toString());

    }

    public void stop() {

    }
}
