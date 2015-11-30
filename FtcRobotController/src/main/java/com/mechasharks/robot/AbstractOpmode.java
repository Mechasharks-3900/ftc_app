package com.mechasharks.robot;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController.RunMode;

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

    public void drive(double left, double right) {
        driveLeft.setPower(left);
        driveRight.setPower(right);
    }

    public void resetEncoders(){
        driveLeft.getController().setMotorChannelMode(1, RunMode.RESET_ENCODERS);
        driveRight.getController().setMotorChannelMode(2, RunMode.RESET_ENCODERS);
        driveLeft.getController().setMotorChannelMode(1, RunMode.RUN_WITHOUT_ENCODERS);
        driveRight.getController().setMotorChannelMode(2, RunMode.RUN_WITHOUT_ENCODERS);
    }

    public void driveTo(int position, float power) {
        driveTo(position, power, true);
    }

    public void driveTo(int position, float power, boolean relative) {
        moveTo(driveLeft, position, power, relative);
        moveTo(driveRight, position, power, relative);
    }

    public void moveTo(DcMotor m, int position, float power, boolean relative) {
        int newVal = position;
        if (relative)
            newVal += m.getCurrentPosition();
        m.setTargetPosition(newVal);
        m.setPower(power);
    }
}
