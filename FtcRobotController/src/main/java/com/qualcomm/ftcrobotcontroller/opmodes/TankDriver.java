package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
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
        DcMotorController.RunMode.RESET_ENCODERS(motorRight);
    }

    @Override
    public void loop() {
        motorLeft.setPower(gamepad1.left_stick_y);
        motorRight.setPower(-1*(gamepad1.right_trigger * 2 - 1));
        telemetry.addData("Text", "*** Robot Data***");
        telemetry.addData("Speed", "left:" + gamepad1.left_stick_y + "right:" + (-1*(gamepad1.right_trigger * 2 - 1)));
        telemetry.addData("Right Encoder", motorRight.getCurrentPosition());
    }
}
