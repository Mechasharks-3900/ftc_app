package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.TouchSensor;

/**
 * Created by stjzito1 on 11/17/2015.
 */
public class AutonomousTest1 extends AutonomousSuper{


    public void init(){
        motorLeft = hardwareMap.dcMotor.get("motor left");
        motorRight = hardwareMap.dcMotor.get("motor right");
        resetEncoder();
    }

    public void start(){
        driveForward(4500, 100);
    }
    public void loop(){
        //does nothing
        telemetry.addData("Right Encoder", motorRight.getChannelMode());
        telemetry.addData("Right Encoder Target", motorRight.getTargetPosition());
        telemetry.addData("Right Encoder Current", motorRight.getCurrentPosition());
        telemetry.addData("Left Encoder", motorLeft.getChannelMode());
        telemetry.addData("Left Encoder Target", motorLeft.getTargetPosition());
        telemetry.addData("Left Encoder Current", motorLeft.getCurrentPosition());
    }
}
