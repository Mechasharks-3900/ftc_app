package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.TouchSensor;

/**
 * Created by stjzito1 on 11/17/2015.
 */
public  abstract class AutonomousSuper extends OpMode {
    //public abstract void loop();
    //public abstract void init();
    DcMotor motorLeft, motorRight;
    //motorLeft=1 motorRight=2
    public void resetEncoder(){
        motorLeft.getController().setMotorChannelMode(1,DcMotorController.RunMode.RESET_ENCODERS);
        motorRight.getController().setMotorChannelMode(2,DcMotorController.RunMode.RESET_ENCODERS);
        motorLeft.getController().setMotorChannelMode(1,DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
        motorRight.getController().setMotorChannelMode(2,DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
    }

    public void driveForward(int distance, int speed) {
        int rightposition = motorRight.getCurrentPosition();
        int leftposition = motorLeft.getCurrentPosition();
        motorRight.setTargetPosition(distance +rightposition);
        motorLeft.setTargetPosition(distance+leftposition);
        motorLeft.setPower(speed/100);
        motorRight.setPower(speed/100);
        motorLeft.getController().setMotorChannelMode(1, DcMotorController.RunMode.RUN_TO_POSITION);
        motorRight.getController().setMotorChannelMode(2, DcMotorController.RunMode.RUN_TO_POSITION);
        //motorRight.setPower(speed);
        //motorLeft.setPower(speed);
    }
}
