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
    private double type = 1;
    private int num = 0;

    private boolean previousA1, previousB1, previousY1, previousD_left, previousD_right;

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
        if (gamepad2.dpad_left && !previousD_left){
            type = 0;
        }
        else if(gamepad2.dpad_right && !previousD_right){
            type = 1;
        }
        else{
            type = 0.5;
        }

        previousA1 = gamepad1.a;
        previousB1 = gamepad1.b;
        previousY1 = gamepad1.y;
        previousD_left = gamepad2.dpad_left;
        previousD_right = gamepad2.dpad_right;
        driveTeleOp(driveMode);
        ServoTo(boxLiftLeft, value);
        ServoTo(boxLiftRight, value);
        ServoTo(flipper, num);
        ServoTo(ballPickerRight, type);
        ServoTo(ballPickerLeft, type);
        telemetry.addData("driveMode", driveMode);
        armExtender(gamepad1.right_trigger + (-1 * gamepad1.left_trigger));
        armLift((gamepad1.left_bumper ? 1 : 0) + (gamepad1.right_bumper ? -1 : 0));
        telemetry.addData("Gyro Z: ", gyroSensor.rawZ());
        telemetry.addData("Gyro heading: ", gyroSensor.getHeading());
    }
}
