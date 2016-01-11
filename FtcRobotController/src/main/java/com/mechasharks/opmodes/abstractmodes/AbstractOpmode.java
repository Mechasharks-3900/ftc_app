package com.mechasharks.opmodes.abstractmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController.RunMode;
import com.qualcomm.robotcore.hardware.GyroSensor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by stjjensen1 on 11/20/2015.
 */
public abstract class AbstractOpMode extends OpMode {
    protected DcMotor driveLeftFront, driveRightFront, driveLeftBack, driveRightBack, extenderRight, extenderLeft, armLift;
    protected Servo boxLiftLeft, boxLiftRight, flipper, BallPickerRight, BallPickerLeft;
    protected GyroSensor gyroSensor;


    @Override
    public void init() {
        int value = 0;
        driveLeftFront = hardwareMap.dcMotor.get("motor left front");
        driveRightFront = hardwareMap.dcMotor.get("motor right front");
        driveLeftBack = hardwareMap.dcMotor.get("motor left back");
        driveRightBack = hardwareMap.dcMotor.get("motor right back");
        extenderLeft = hardwareMap.dcMotor.get("extender left");
        extenderRight = hardwareMap.dcMotor.get("extender right");
        armLift = hardwareMap.dcMotor.get("lift");
        boxLiftLeft = hardwareMap.servo.get("box lift left");
        boxLiftRight = hardwareMap.servo.get("box lift left");
        flipper = hardwareMap.servo.get("flip");
        BallPickerRight = hardwareMap.servo.get("ball picker right");
        BallPickerLeft = hardwareMap.servo.get("ball picker left");
        gyroSensor = hardwareMap.gyroSensor.get("gyro main");
        gyroSensor.calibrate();
        resetEncoders();
    }

    public void drive(double left, double right) {
        driveLeftFront.setChannelMode(RunMode.RUN_WITHOUT_ENCODERS);
        driveRightFront.setChannelMode(RunMode.RUN_WITHOUT_ENCODERS);
        driveLeftBack.setChannelMode(RunMode.RUN_WITHOUT_ENCODERS);
        driveRightBack.setChannelMode(RunMode.RUN_WITHOUT_ENCODERS);
        driveLeftBack.setPower(left);
        driveRightBack.setPower(-right);
        driveLeftFront.setPower(-left);
        driveRightFront.setPower(right);
    }

    public void resetEncoders() {
        for (DcMotor motor : hardwareMap.dcMotor)
            motor.setMode(RunMode.RESET_ENCODERS);
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
        m.setPower(power / 100);
    }

    public void move(DcMotor m, double power) {
        m.setChannelMode(RunMode.RUN_WITHOUT_ENCODERS);
        m.setPower(power);
    }

    public void wait1Msec(int delay)
    {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void ServoTo(Servo a, int pos) {
        a.setPosition(pos);
        telemetry.addData(a + " target", pos);
        telemetry.addData(a + " position", a.getPosition());
    }

    public void armExtender(double power){
        extenderRight.setPower(power);
        extenderLeft.setPower(power);
        extenderLeft.setChannelMode(RunMode.RUN_USING_ENCODERS);
        extenderRight.setChannelMode(RunMode.RUN_USING_ENCODERS);
    }

    public void armExtendTo(int pos){
        moveTo(extenderLeft, pos,75,false);
        moveTo(extenderRight,pos,75,false);
    }
    public void armLift(double power){
        armLift.setPower(power);
    }
    public void armLiftTo(int pos){
        moveTo(armLift, pos, 75, false);
    }
}

