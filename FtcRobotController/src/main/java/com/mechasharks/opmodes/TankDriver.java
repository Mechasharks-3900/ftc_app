package com.mechasharks.opmodes;

import com.mechasharks.Register;
import com.mechasharks.opmodes.abstractmodes.TeleOp;

/**
 * Created by stjjensen1 on 11/20/2015.
 */

@Register(name = "Tank Driver")
public class TankDriver extends TeleOp {

    private DriveMode driveMode = DriveMode.DIRECT;
    private int value = 1;
    private double boxLeft = 1;
    private double boxRight = 1;
    private int num = 0;
    private double clip = 0.25;

    private boolean previousA1, previousB1, previousY1, previousD_left, previousD_right, previousD_up, previousD_down, previousRight_Bumper, previousLeft_Bumper;

    @Override
    public void loop() {
        if (gamepad1.a && !previousA1) {
            driveMode = (driveMode == DriveMode.DIRECT)
                    ? DriveMode.ARCADE
                    : DriveMode.DIRECT;
        }
        if (gamepad1.b && !previousB1) {
            value = 1 - value;
        }
        if (gamepad1.y && !previousY1) {
            num = 1 - num;
        }
        if (gamepad1.right_bumper && !previousRight_Bumper){
            clip = 1 - clip;
        }
        if (gamepad1.left_bumper && !previousLeft_Bumper){
            clip = 1 - clip;
        }
        if (gamepad1.dpad_left && !previousD_left){
            boxLeft = 0;
        }
        else if(gamepad1.dpad_right && !previousD_right){
            boxLeft = 1;
        }
        else{
            boxLeft = 0.5;
        }
        if (gamepad1.dpad_up && !previousD_up){
            boxRight = 0;
        }
        else if(gamepad1.dpad_down && !previousD_down){
            boxRight = 1;
        }
        else{
            boxRight = 0.5;
        }

        previousA1 = gamepad1.a;
        previousB1 = gamepad1.b;
        previousY1 = gamepad1.y;
        previousD_left = gamepad1.dpad_left;
        previousD_right = gamepad1.dpad_right;
        previousRight_Bumper = gamepad1.right_bumper;
        previousLeft_Bumper = gamepad1.left_bumper;
        previousD_down = gamepad1.dpad_down;
        previousD_up = gamepad1.dpad_up;

        driveTeleOp(driveMode);
        ServoTo(boxLiftLeft, 1-value);
        ServoTo(boxLiftRight, value);
        ServoTo(flipper, num);
        ServoTo(ballPickerRight, boxRight);
        ServoTo(ballPickerLeft, boxLeft);
        ServoTo(clipRight, clip);
        ServoTo(clipLeft, clip);
        telemetry.addData("driveMode", driveMode);
        armExtender(gamepad1.right_trigger + (-1 * gamepad1.left_trigger));
        armLift((gamepad1.left_bumper ? 1 : 0) + (gamepad1.right_bumper ? -1 : 0));
        telemetry.addData("Gyro Z: ", gyroSensor.rawZ());
        telemetry.addData("Gyro heading: ", gyroSensor.getHeading());
    }
}
