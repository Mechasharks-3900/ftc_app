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
    }

    public void loop(){
        //does nothing
        driveForward(100,100);
        telemetry.addData("Right Encoder", motorRight.getCurrentPosition());
    }
}
