package com.mechasharks.opmodes;

import com.mechasharks.Register;
import com.mechasharks.opmodes.abstractmodes.AutonomousOp;
import com.mechasharks.opmodes.abstractmodes.TeleOp;

/**
 * Created by stjjensen1 on 11/20/2015.
 */

@Register(name = "Tank Driver")
public class TankDriver extends TeleOp {

    private TankMode tankMode = TankMode.DIRECT;
    private int value = 1;
    private int type = 1;
    private int num = 1;

    @Override
    public void loop() {
        if (gamepad1.a) {
            tankMode = (tankMode == TankMode.DIRECT)
                    ? TankMode.SINGLE_JOYSTICK
                    : TankMode.DIRECT;
        }
        if (gamepad1.b) {
            value = (value == 1)
                    ? 0
                    : 1;
        }
        if (gamepad1.x){
            type = (type == 1)
                    ? 0
                    : 1;
        }
        if (gamepad1.y){
            num = (num == 1)
                    ? 0
                    : 1;
        }
        driveTeleOp(tankMode);
        ServoTo(boxLiftLeft, value);
        ServoTo(boxLiftRight, type);
        ServoFlip(flipper, num);
        telemetry.addData("tankMode", tankMode);
        armExtender(gamepad1.right_trigger+(-1*gamepad1.left_trigger));
        telemetry.addData("Gyro Z: ", gyroSensor.rawZ());
        telemetry.addData("Gyro heading: ", gyroSensor.getHeading());

    }
}
