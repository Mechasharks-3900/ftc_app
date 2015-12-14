package com.mechasharks.opmodes;

import com.mechasharks.Register;
import com.mechasharks.opmodes.abstractmodes.TeleOp;

/**
 * Created by stjjensen1 on 11/20/2015.
 */

@Register(name = "Tank Driver")
public class TankDriver extends TeleOp {

    private TankMode tankMode = TankMode.DIRECT;
    private int value = 1;

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
        driveTeleOp(tankMode);
        ServoTo(flipper, value);
        telemetry.addData("tankMode", tankMode);
    }
}
