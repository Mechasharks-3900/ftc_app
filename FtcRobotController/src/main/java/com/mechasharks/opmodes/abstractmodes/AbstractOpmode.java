package com.mechasharks.opmodes.abstractmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController.RunMode;

/**
 * Created by stjjensen1 on 11/20/2015.
 */
public abstract class AbstractOpMode extends OpMode {
    protected DcMotor driveLeft, driveRight, driveFrontLeft, driveFrontRight;


    @Override
    public void init() {
        driveLeft = hardwareMap.dcMotor.get("motor left");
        driveRight = hardwareMap.dcMotor.get("motor right");
        driveFrontLeft = hardwareMap.dcMotor.get("motor front left");
        driveFrontRight = hardwareMap.dcMotor.get("motor front right");
        resetEncoders();
    }

    public void drive(double left, double right) {
        move(driveLeft, left);
        move(driveRight, right);
        move(driveFrontLeft, left);
        move(driveFrontRight, right);
    }

    public void resetEncoders(){
        driveLeft.setChannelMode(RunMode.RESET_ENCODERS);
        driveRight.setChannelMode(RunMode.RESET_ENCODERS);
        driveFrontLeft.setChannelMode(RunMode.RESET_ENCODERS);
        driveFrontRight.setChannelMode(RunMode.RESET_ENCODERS);
    }

    public void driveTo(int position, float power) {
        driveTo(position, power, true);
    }

    public void driveTo(int position, float power, boolean relative) {
        moveTo(driveLeft, position, power, relative);
        moveTo(driveFrontLeft, position, power, relative);
        moveTo(driveFrontRight, position, power, relative);
        moveTo(driveRight, position, power, relative);
    }

    public void moveTo(DcMotor m, int position, float power, boolean relative) {
        int newVal = position;
        if (relative)
            newVal += m.getCurrentPosition();
        m.setChannelMode(RunMode.RUN_TO_POSITION);
        m.setTargetPosition(newVal);
        m.setPower(power / 100);
    }

    public void move(DcMotor m, double power) {
        m.setChannelMode(RunMode.RUN_WITHOUT_ENCODERS);
        m.setPower(power);
    }
}
