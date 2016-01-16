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
    private double boxLeft = .5;
    private double boxRight = .5;
    private int num = 0;
    private double clip = 0.25;

    private boolean previousA1, previousB1, previousY1, previousD_left, previousD_right, previousD_up, previousD_down, previousRight_Bumper, previousLeft_Bumper;

    @Override
    public void loop() {
        if (gamepad1.y && !previousA1) {
            driveMode = (driveMode == DriveMode.DIRECT)
                    ? DriveMode.ARCADE
                    : DriveMode.DIRECT;
        }
        if (gamepad2.b && !previousB1) {
            value = 1 - value;
        }
        if (gamepad2.y && !previousY1) {
            num = 1 - num;
        }
        if (gamepad2.right_bumper && !previousRight_Bumper){
            clip = 1 - clip;
        }
        if (gamepad2.left_bumper && !previousLeft_Bumper){
            clip = 1 - clip;
        }
        if (gamepad1.left_trigger>.7 && !gamepad1.left_bumper){
            boxRight = 0;
        }
        else if(gamepad1.left_trigger<.2 && gamepad1.left_bumper){
            boxRight = 1;
        }
        else{
            boxRight = 0.5;
        }

        if (gamepad1.right_trigger>.7 && !gamepad1.right_bumper){
            boxRight = 0;
        }
        else if(gamepad1.right_trigger<.2 && gamepad1.right_bumper){
            boxRight = 1;
        }
        else{
            boxRight = 0.5;
        }

        previousA1 = gamepad1.a;
        previousB1 = gamepad2.b;
        previousY1 = gamepad2.y;
        previousD_left = gamepad2.dpad_left;
        previousD_right = gamepad2.dpad_right;
        previousRight_Bumper = gamepad2.right_bumper;
        previousLeft_Bumper = gamepad2.left_bumper;
        previousD_down = gamepad2.dpad_down;
        previousD_up = gamepad2.dpad_up;

        driveTeleOp(driveMode);
        ServoTo(boxLiftLeft, 1-value);
        ServoTo(boxLiftRight, value);
        ServoTo(flipper, num);
        ServoTo(ballPickerRight, boxRight);
        ServoTo(ballPickerLeft, boxLeft);
        ServoTo(clipRight, clip);
        ServoTo(clipLeft, clip);
        telemetry.addData("driveMode", driveMode);
        armExtender(gamepad2.right_trigger + (-1 * gamepad2.left_trigger));
        armLift((gamepad2.left_bumper ? 1 : 0) + (gamepad2.right_bumper ? -1 : 0));
        telemetry.addData("Gyro Z: ", gyroSensor.rawZ());
        telemetry.addData("Gyro heading: ", gyroSensor.getHeading());
    }
}
