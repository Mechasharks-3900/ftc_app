package com.qualcomm.ftcrobotcontroller.opmodes;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.TouchSensor;

/**
 * Created by stjzito1 on 11/23/2015.
 */
public abstract class Super extends OpMode {
    //public abstract void loop();
    //public abstract void init();
    //motorLeft=1 motorRight=2
    DcMotor motorLeft, motorRight;
    int tankMode;
    public void setup(){
        motorLeft = hardwareMap.dcMotor.get("motor left");
        motorRight = hardwareMap.dcMotor.get("motor right");
        int tankMode = 1;
    }
    public void resetEncoder(){
        motorLeft.getController().setMotorChannelMode(1, DcMotorController.RunMode.RESET_ENCODERS);
        motorRight.getController().setMotorChannelMode(2,DcMotorController.RunMode.RESET_ENCODERS);
        motorLeft.getController().setMotorChannelMode(1, DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
        motorRight.getController().setMotorChannelMode(2, DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
    }
    public void tankDrive(){
        motorLeft.setPower((gamepad1.left_stick_y));
        motorRight.setPower((-1 * (gamepad1.right_trigger * 2 - 1)));
    }
    public void singleStickDrive(){
        double ratio=((-1*(gamepad1.right_trigger * 2 - 1))+1)/2;
        motorLeft.setPower((-1 * (gamepad1.left_trigger * 2 - 1)) * (1 - ratio));
        motorRight.setPower((-1*(gamepad1.left_trigger * 2 - 1))*ratio);
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
    public void setPower(){
        if (tankMode % 2 == 1) {
            tankDrive();
        } else if (tankMode % 2 == 2) {
            singleStickDrive();
        }
    }
    public void driveTeleOP(){
        if(gamepad1.right_stick_button==true){

            tankMode=tankMode+1;
        }
        setPower();
    }
}
