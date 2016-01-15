package com.mechasharks.opmodes.abstractmodes;

import com.mechasharks.MotorGroup;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController.RunMode;
import com.qualcomm.robotcore.hardware.GyroSensor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;

/**
 * Created by stjjensen1 on 11/20/2015.
 */
public abstract class AbstractOpMode extends OpMode {
    protected DcMotor driveLeftFront, driveRightFront, driveLeftBack, driveRightBack, extenderRight, extenderLeft, armLift;
    protected Servo boxLiftLeft, boxLiftRight, flipper, ballPickerRight, ballPickerLeft, clipRight, clipLeft;
    public GyroSensor gyroSensor;
    protected MotorGroup driveMotors;
    protected TouchSensor leadScrewArm, armHook;

    @Override
    public void init() {
        driveLeftFront = hardwareMap.dcMotor.get("motor left front");
        driveRightFront = hardwareMap.dcMotor.get("motor right front");
        driveLeftBack = hardwareMap.dcMotor.get("motor left back");
        driveRightBack = hardwareMap.dcMotor.get("motor right back");
        driveMotors = new MotorGroup(driveLeftFront, driveLeftBack, driveRightFront, driveRightBack);
        extenderLeft = hardwareMap.dcMotor.get("extender left");
        extenderRight = hardwareMap.dcMotor.get("extender right");
        armLift = hardwareMap.dcMotor.get("lift");
        boxLiftLeft = hardwareMap.servo.get("box lift left");
        boxLiftRight = hardwareMap.servo.get("box lift right");
        flipper = hardwareMap.servo.get("flip");
        ballPickerRight = hardwareMap.servo.get("ball picker right");
        ballPickerLeft = hardwareMap.servo.get("ball picker left");
        clipRight = hardwareMap.servo.get("clip right");
        clipLeft = hardwareMap.servo.get("clip left");
        gyroSensor = hardwareMap.gyroSensor.get("gyro main");
        leadScrewArm = hardwareMap.touchSensor.get("lead screw arm");
        armHook = hardwareMap.touchSensor.get("arm Hook");
        gyroSensor.calibrate();
        resetEncoders();
    }

    public void drive(double left, double right) {
        driveLeftFront.setMode(RunMode.RUN_WITHOUT_ENCODERS);
        driveRightFront.setMode(RunMode.RUN_WITHOUT_ENCODERS);
        driveLeftBack.setMode(RunMode.RUN_WITHOUT_ENCODERS);
        driveRightBack.setMode(RunMode.RUN_WITHOUT_ENCODERS);
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

    public int driveTo(int position, float power, boolean relative) {
        int avg = moveTo(driveLeftFront, position, power) +
                moveTo(driveRightFront, position, power) +
                moveTo(driveLeftBack, position, power) +
                moveTo(driveRightBack, position, power);
        return avg / 4;
    }

    public int moveTo(DcMotor m, int position, double power) {
        m.setMode(RunMode.RUN_TO_POSITION);
        m.setTargetPosition(position);
        m.setPower(power);
        return position - m.getCurrentPosition();
    }

    public void move(DcMotor m, double power) {
        m.setMode(RunMode.RUN_WITHOUT_ENCODERS);
        m.setPower(power);
    }

    public void ServoTo(Servo a, double pos) {
        a.setPosition(pos);
        telemetry.addData(a + " target", pos);
        telemetry.addData(a + " position", a.getPosition());
    }

    public void armExtender(double power) {
        extenderRight.setPower(power);
        extenderLeft.setPower(-power);
        extenderLeft.setMode(RunMode.RUN_USING_ENCODERS);
        extenderRight.setMode(RunMode.RUN_USING_ENCODERS);
    }

    public int armExtendTo(int pos) {
        return (moveTo(extenderLeft, pos, 75) +
                moveTo(extenderRight, pos, 75)) / 2;
    }

    public void armLift(double power) {
        armLift.setMode(RunMode.RUN_USING_ENCODERS);
        armLift.setPower(power);
    }

    public int armLiftTo(int pos) {
        return moveTo(armLift, pos, 75);
    }
}

