package com.mechasharks.robot;

/**
 * Created by stjzito1 on 11/17/2015.
 */
@Register(name = "Autonomous Test")
public class AutonomousTest1 extends AutonomousOp {

    public void init(){
        super.init();
        resetEncoders();
    }

    public void start(){
        driveTo(4500, 100);
    }
    public void loop(){
        telemetry.addData("Right Encoder", driveRight.getChannelMode());
        telemetry.addData("Right Encoder Target", driveRight.getTargetPosition());
        telemetry.addData("Right Encoder Current", driveRight.getCurrentPosition());
        telemetry.addData("Left Encoder", driveLeft.getChannelMode());
        telemetry.addData("Left Encoder Target", driveLeft.getTargetPosition());
        telemetry.addData("Left Encoder Current", driveLeft.getCurrentPosition());
    }
}
