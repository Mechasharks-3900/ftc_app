package com.mechasharks.opmodes.abstractmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController.RunMode;

/**
 * Created by stjjensen1 on 11/20/2015.
 */
public abstract class AbstractOpMode extends OpMode {
    protected DcMotor driveLeft, driveRight;


    @Override
    public void init() {
        driveLeft = hardwareMap.dcMotor.get("motor left");
        driveRight = hardwareMap.dcMotor.get("motor right");
        resetEncoders();
    }

    public void drive(double left, double right) {
        driveLeft.setChannelMode(RunMode.RUN_WITHOUT_ENCODERS);
        driveLeft.setChannelMode(RunMode.RUN_WITHOUT_ENCODERS);
        driveLeft.setPower(left);
        driveRight.setPower(right);
    }

    public void resetEncoders(){
        driveLeft.setChannelMode(RunMode.RESET_ENCODERS);
        driveRight.setChannelMode(RunMode.RESET_ENCODERS);
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
        m.setChannelMode(RunMode.RUN_TO_POSITION);
        m.setTargetPosition(newVal);
        m.setPower(power/100);
    }
}
