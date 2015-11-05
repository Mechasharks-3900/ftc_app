package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.TouchSensor;

/**
 * Created by stjjensen1 on 10/30/2015.
 */
public class TankDriver extends OpMode {
    DcMotor motorLeft, motorRight;
    TouchSensor touch;


    @Override
    public void init() {
        motorLeft = hardwareMap.dcMotor.get("motor left");
        motorRight = hardwareMap.dcMotor.get("motor right");
        touch = hardwareMap.touchSensor.get("touch sensor");
    }

    @Override
    public void loop() {
        motorLeft.setPower(gamepad1.left_stick_y);
        motorRight.setPower(gamepad1.right_trigger * 2 - 1);
    }
}
