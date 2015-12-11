package com.mechasharks.opmodes.abstractmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController.RunMode;

/**
 * Created by stjjensen1 on 11/20/2015.
 */
public abstract class AbstractOpMode extends OpMode {
    protected DcMotor driveLeftFront, driveRightFront, driveLeftBack, driveRightBack;


    @Override
    public void init() {
        driveLeftFront = hardwareMap.dcMotor.get("motor left front");
        driveRightFront = hardwareMap.dcMotor.get("motor right front");
        driveLeftBack = hardwareMap.dcMotor.get("motor left back");
        driveRightBack = hardwareMap.dcMotor.get("motor right back");
        resetEncoders();
    }

    public void drive(double left, double right) {
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
    }

    public void driveTo(int position, float power) {
        driveTo(position, power, true);
    }

    public void driveTo(int position, float power, boolean relative) {
        moveTo(driveLeftFront, position, power, relative);
        moveTo(driveRightFront, position, power, relative);
        moveTo(driveLeftBack, position, power, relative);
        moveTo(driveRightBack, position, power, relative);
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
