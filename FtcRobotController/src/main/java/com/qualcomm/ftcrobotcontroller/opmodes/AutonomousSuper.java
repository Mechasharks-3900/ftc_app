package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.TouchSensor;

/**
 * Created by stjzito1 on 11/17/2015.
 */
public  abstract class AutonomousSuper extends OpMode {
    public abstract void loop();
    public abstract void init();
    DcMotor motorLeft, motorRight;
    public void resetEncoder(){
        motorLeft.getController().setMotorChannelMode(1,DcMotorController.RunMode.RESET_ENCODERS);
        motorRight.getController().setMotorChannelMode(1,DcMotorController.RunMode.RESET_ENCODERS);
    }

    public void drive(int distance, int speed) {
        int rightposition = motorRight.getCurrentPosition();
        int leftposition = motorLeft.getCurrentPosition();
        motorRight.setTargetPosition(distance - rightposition);
        motorLeft.setTargetPosition(distance - leftposition);
        motorLeft.getController().setMotorChannelMode(1, DcMotorController.RunMode.RUN_TO_POSITION);
        motorRight.getController().setMotorChannelMode(1, DcMotorController.RunMode.RUN_TO_POSITION);
        //motorRight.setPower(speed);
        //motorLeft.setPower(speed);
    }
}
