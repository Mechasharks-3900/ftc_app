package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.TouchSensor;

/**
 * Created by stjzito1 on 11/17/2015.
 */
public class Autonomousbasics extends autonomoustest {

    DcMotor motorLeft, motorRight;
    public void resetEncoder(){
        motorLeft.getController().setMotorChannelMode(1,);
    }

    public void drive(int distance, float speed) {
        int rightposition = motorRight.getCurrentPosition();
        int leftposition = motorLeft.getCurrentPosition();
        motorRight.setTargetPosition(distance - rightposition);
        motorLeft.setTargetPosition(distance - leftposition);
        //motorRight.setPower(speed);
        //motorLeft.setPower(speed);
    }
}
