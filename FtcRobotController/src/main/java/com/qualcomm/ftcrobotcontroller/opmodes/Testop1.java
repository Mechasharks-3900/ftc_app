package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.TouchSensor;

/**
 * Created by stjzito1 on 10/13/2015.
 */
public class Testop1 extends OpMode {
    DcMotor motor_1;
    TouchSensor touch;

    /*public Testop1() {
        super();
    }*/

    public void init() {
        motor_1 = hardwareMap.dcMotor.get("motor_1");
        touch = hardwareMap.touchSensor.get("touch");
    }

    public void loop() {
        float throttle = touch.isPressed() ? 1 : 0;
        motor_1.setPower(throttle);

    }

    public void stop() {
    }
}
