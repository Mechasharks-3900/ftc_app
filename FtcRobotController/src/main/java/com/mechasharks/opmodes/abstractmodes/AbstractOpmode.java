package com.mechasharks.opmodes.abstractmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController.RunMode;

/**
 * Created by stjjensen1 on 11/20/2015.
 */
public abstract class AbstractOpMode extends OpMode {
<<<<<<< HEAD
    protected DcMotor driveLeftFront, driveRightFront, driveLeftBack, driveRightBack;
=======
    protected DcMotor driveLeft, driveRight, driveFrontLeft, driveFrontRight;
>>>>>>> origin/master


    @Override
    public void init() {
<<<<<<< HEAD
        driveLeftFront = hardwareMap.dcMotor.get("motor left front");
        driveRightFront = hardwareMap.dcMotor.get("motor right front");
        driveLeftBack = hardwareMap.dcMotor.get("motor left back");
        driveRightBack = hardwareMap.dcMotor.get("motor right back");
=======
        driveLeft = hardwareMap.dcMotor.get("motor left");
        driveRight = hardwareMap.dcMotor.get("motor right");
        driveFrontLeft = hardwareMap.dcMotor.get("motor front left");
        driveFrontRight = hardwareMap.dcMotor.get("motor front right");
>>>>>>> origin/master
        resetEncoders();
    }

    public void drive(double left, double right) {
<<<<<<< HEAD
        driveLeftFront.setChannelMode(RunMode.RUN_WITHOUT_ENCODERS);
        driveRightFront.setChannelMode(RunMode.RUN_WITHOUT_ENCODERS);
        driveLeftBack.setPower(left);
        driveRightBack.setPower(right);
    }

    public void resetEncoders(){
        driveLeftFront.setChannelMode(RunMode.RESET_ENCODERS);
        driveRightFront.setChannelMode(RunMode.RESET_ENCODERS);
        driveLeftBack.setChannelMode(RunMode.RESET_ENCODERS);
        driveRightBack.setChannelMode(RunMode.RESET_ENCODERS);
=======
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
>>>>>>> origin/master
    }

    public void driveTo(int position, float power) {
        driveTo(position, power, true);
    }

    public void driveTo(int position, float power, boolean relative) {
<<<<<<< HEAD
        moveTo(driveLeftFront, position, power, relative);
        moveTo(driveRightFront, position, power, relative);
        moveTo(driveLeftBack, position, power, relative);
        moveTo(driveRightBack, position, power, relative);
=======
        moveTo(driveLeft, position, power, relative);
        moveTo(driveFrontLeft, position, power, relative);
        moveTo(driveFrontRight, position, power, relative);
        moveTo(driveRight, position, power, relative);
>>>>>>> origin/master
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
