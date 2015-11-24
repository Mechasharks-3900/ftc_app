package com.mechasharks.robot;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by stjjensen1 on 11/20/2015.
 */
public abstract class AbstractOpmode extends OpMode {
    protected DcMotor driveLeft, driveRight;


    @Override
    public void init() {
        driveLeft = hardwareMap.dcMotor.get("motor left");
        driveRight = hardwareMap.dcMotor.get("motor right");
    }

    public void drive(float left, float right) {
        driveLeft.setPower(left);
        driveRight.setPower(right);

    }
}
