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
    private int type = 1;
    private int num = 1;

    private boolean previousA1, previousB1, previousY1;

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
        previousA1 = gamepad1.a;
        previousB1 = gamepad1.b;
        previousY1 = gamepad1.y;

        driveTeleOp(driveMode);
        ServoTo(boxLiftLeft, value);
        ServoTo(boxLiftRight, value);
        ServoTo(flipper, num);
        telemetry.addData("driveMode", driveMode);
        armExtender(gamepad1.right_trigger + (-1 * gamepad1.left_trigger));
        armLift((gamepad1.left_bumper ? 1 : 0) + (gamepad1.right_bumper ? -1 : 0));
        telemetry.addData("Gyro Z: ", gyroSensor.rawZ());
        telemetry.addData("Gyro heading: ", gyroSensor.getHeading());

    }
}
