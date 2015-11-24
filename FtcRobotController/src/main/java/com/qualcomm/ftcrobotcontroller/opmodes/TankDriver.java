package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.TouchSensor;

/**
 * Created by stjjensen1 on 10/30/2015.
 */
public class TankDriver extends OpMode {
    DcMotor motorLeft, motorRight;
    TouchSensor touch;
    int tankMode;

    @Override
    public void init() {
        tankMode=1;
        motorLeft = hardwareMap.dcMotor.get("motor left");
        motorRight = hardwareMap.dcMotor.get("motor right");
        touch = hardwareMap.touchSensor.get("touch sensor");
        /*
        This makes the robot controls lag considerably

        motorRight.getController().setMotorChannelMode(2, DcMotorController.RunMode.RESET_ENCODERS);
        motorLeft.getController().setMotorChannelMode(1, DcMotorController.RunMode.RESET_ENCODERS);
        motorRight.getController().setMotorChannelMode(2, DcMotorController.RunMode.RUN_USING_ENCODERS);
        motorLeft.getController().setMotorChannelMode(1, DcMotorController.RunMode.RUN_USING_ENCODERS);
        */
    }
    public void setPower(){
        //tank modes
        //1==tank
        //2==right stick only

        if(tankMode%2==1){
            motorLeft.setPower((gamepad1.left_stick_y));
            motorRight.setPower((-1*(gamepad1.right_trigger * 2 - 1)));
        }else if(tankMode%2==2){
            double ratio=((-1*(gamepad1.right_trigger * 2 - 1))+1)/2;
            motorLeft.setPower((-1*(gamepad1.left_trigger * 2 - 1))*(1-ratio));
            motorRight.setPower((-1*(gamepad1.left_trigger * 2 - 1))*ratio);

        }
    }
    @Override
    public void loop() {
        if(gamepad1.right_stick_button==true){

            tankMode=tankMode+1;
        }
        setPower();

        telemetry.addData("Text", "*** Robot Data***");
        telemetry.addData("Speed", "left:" + gamepad1.left_stick_y + "right:" + (-1*(gamepad1.right_trigger * 2 - 1)));
        telemetry.addData("Right Encoder", motorRight.getCurrentPosition());
    }
}
